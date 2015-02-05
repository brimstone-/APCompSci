//*********************************************************
// ExpensePlannerGUI.java
//
// GUI to calculate buying items on a wishlist with funds
// gained on a monthly basis.
// Items are bought in queue order.
//*********************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ExpensePlannerGUI {
    private int WIDTH = 700;
    private int HEIGHT = 200;

    private JFrame frame;
    private JPanel panel;

    private JFrame itemFrame;
    private JPanel itemPanel;

    private JLabel setAllowanceLabel;
    private TextField setAllowanceField;
    private int allowance = 0;

    private JLabel currentAllowanceLabel;
    private TextField currentAllowanceField;

    private JButton nextButton;
    private int balance = 0;
    private JLabel currentBalanceLabel;
    private TextField currentBalanceField;

    private JLabel currentMonthLabel;
    private TextField currentMonthField;
    private int month = 1;
    private String currentMonth;

    private JLabel itemNameLabel;
    private JLabel itemCostLabel;

    private TextField itemCostField;
    private TextField itemNameField;

    private JButton itemButton;

    private JButton wishlistButton;
    private JLabel wishlistLabel;

    LinkedList<Item> wishes = new LinkedList<Item>();
    //----------------------------------------------
    // Constructor: Sets up the GUI.
    //----------------------------------------------
    public ExpensePlannerGUI() {
        frame = new JFrame ("Expense Planner");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        panel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
        panel.setBackground (Color.gray);

        setAllowanceLabel = new JLabel("Set the Monthly Allowance");
        setAllowanceField = new TextField(15);

        currentAllowanceLabel = new JLabel("Allowance set aside each month");
        currentAllowanceField = new TextField(15);

        setAllowanceField.addActionListener(new allowanceButtonListener());

        nextButton = new JButton("Go to next month");
        nextButton.addActionListener(new nextButtonListener());

        currentBalanceLabel = new JLabel("Current Balance: ");
        currentBalanceField = new TextField(15);

        currentMonthLabel = new JLabel("Current Month: ");
        currentMonthField = new TextField(15);

        itemButton = new JButton("Add an item to the wishlist");
        itemButton.addActionListener(new itemButtonListener());

        itemNameLabel = new JLabel("Item Name: ");
        itemCostLabel = new JLabel("Item Cost: ");

        itemCostField = new TextField(15);
        itemNameField = new TextField(15);

        wishlistButton = new JButton("View current wishlist");
        wishlistButton.addActionListener(new wishlistButtonListener());

        wishlistLabel = new JLabel("");

        panel.add(setAllowanceLabel);
        panel.add(setAllowanceField);

        panel.add(currentAllowanceLabel);
        panel.add(currentAllowanceField);

        panel.add(currentBalanceLabel);
        panel.add(currentBalanceField);

        panel.add(currentMonthLabel);
        panel.add(currentMonthField);

        panel.add(nextButton);

        panel.add(itemNameLabel);
        panel.add(itemNameField);
        panel.add(itemCostLabel);
        panel.add(itemCostField);
        panel.add(itemButton);

        panel.add(wishlistButton);
        panel.add(wishlistLabel);

        frame.getContentPane().add (panel, BorderLayout.LINE_START);
    }
    //-----------------------------------------------------------------
    //  Displays the primary application frame.
    //-----------------------------------------------------------------
    public void display() {
        frame.pack();
        frame.setVisible(true);
    }
    public void itemDisplay() {
        itemFrame.pack();
        itemFrame.setVisible(true);
    }
    //***************************************************
    // Represents a listener for button push (action) events
    //***************************************************
    private class allowanceButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            allowance = Integer.parseInt(setAllowanceField.getText());
            currentAllowanceField.setText("");
            currentAllowanceField.setText(allowance + "");
        }
    }
    private class nextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            balance += allowance;

            while (!wishes.isEmpty() && wishes.peek().getCost() < balance) {
                Item temp = wishes.getFirst();
                while (temp != null && temp.getCost() < balance) {
                    balance -= temp.getCost();

                    wishes.remove();

                    if (wishes.peek() != null) temp = wishes.getFirst();
                    else temp = null;
                }
            }
            currentBalanceField.setText("");
            currentBalanceField.setText(balance + "");

            month++;
            if (month > 12) month = 1;
            currentMonth = returnMonth(month);
            currentMonthField.setText(currentMonth);
        }
    }
    private class itemButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Item buyThis = new Item(itemNameField.getText(), Integer.parseInt(itemCostField.getText()));
            wishes.add(buyThis);
        }
    }
    private class wishlistButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (!wishes.isEmpty()) {
                wishlistLabel.setText("Items to be bought:   " + wishes.toString() + "");
            }
            else {
                wishlistLabel.setText("No items to be bought, add something to the wishlist!");
            }
        }
    }
    public static String returnMonth(int num) {
        if      (num == 1)  return "Janurary";
        else if (num == 2)  return "February";
        else if (num == 3)  return "March";
        else if (num == 4)  return "April";
        else if (num == 5)  return "May";
        else if (num == 6)  return "June";
        else if (num == 7)  return "July";
        else if (num == 8)  return "August";
        else if (num == 9)  return "September";
        else if (num == 10) return "October";
        else if (num == 11) return "November";
        else                return "December";
    }
}