//-----------------------------------------------------------------
// ExpensePlannerGUI.java
//
// GUI to calculate buying items on a wishlist with funds
// gained on a monthly basis.
// Items are bought in queue order.
//-----------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ExpensePlannerGUI {
    private int WIDTH = 700;
    private int HEIGHT = 300;

    private JFrame frame;
    private JPanel panel;

    private JFrame itemFrame;
    private JPanel itemPanel;

    private JLabel setAllowanceLabel;
    private TextField setAllowanceField;
    private JLabel currentAllowanceLabel;
    private JLabel currentAllowanceAlert;
    private int allowance = 0;

    private JButton nextButton;
    private int balance = 0;
    private JLabel currentBalanceLabel;

    private JLabel currentMonthLabel;
    private int month = 1;
    private String currentMonth;

    private JLabel itemNameLabel;
    private JLabel itemCostLabel;

    private TextField itemCostField;
    private TextField itemNameField;

    private JLabel confirmationLabel;
    private JLabel itemBoughtLabel;
    private String itemBought = "";
    private JButton itemButton;

    private JButton wishlistButton;
    private JLabel wishlistLabel;

    LinkedList<Item> wishes = new LinkedList<Item>();
    //-----------------------------------------------------------------
    // Constructor: Sets up the GUI.
    //-----------------------------------------------------------------
    public ExpensePlannerGUI() {
        frame = new JFrame ("Expense Planner");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
        panel.setBackground (Color.gray);

        setAllowanceLabel = new JLabel("Set the Monthly Allowance (Press <ENTER>)");
        setAllowanceField = new TextField(15);
        currentAllowanceLabel = new JLabel("Allowance set aside each month: ");
        setAllowanceField.addActionListener(new allowanceFieldListener());
        currentAllowanceAlert = new JLabel("");

        nextButton = new JButton("Go to next month");
        nextButton.addActionListener(new nextButtonListener());

        currentBalanceLabel = new JLabel("Current Balance: ");
        currentMonthLabel = new JLabel("Current Month: ");

        itemButton = new JButton("Add an item to the wishlist");
        itemButton.addActionListener(new itemButtonListener());
        itemNameLabel = new JLabel("Item Name: ");
        itemCostLabel = new JLabel("Item Cost: ");
        itemCostField = new TextField(15);
        itemNameField = new TextField(15);

        confirmationLabel = new JLabel("");
        itemBoughtLabel = new JLabel("");

        wishlistButton = new JButton("View current wishlist");
        wishlistButton.addActionListener(new wishlistButtonListener());
        wishlistLabel = new JLabel("");

        panel.add(setAllowanceLabel);
        panel.add(currentAllowanceAlert);
        panel.add(setAllowanceField);
        panel.add(currentAllowanceLabel);
        panel.add(currentBalanceLabel);
        panel.add(currentMonthLabel);
        panel.add(nextButton);
        panel.add(itemBoughtLabel);
        panel.add(itemNameLabel);
        panel.add(itemNameField);
        panel.add(itemCostLabel);
        panel.add(itemCostField);
        panel.add(confirmationLabel);
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
    //-----------------------------------------------------------------
    // Represents a listener for button push (action) events
    //-----------------------------------------------------------------
    private class allowanceFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (!setAllowanceField.getText().trim().equals("")) {
                allowance = Integer.parseInt(setAllowanceField.getText());
                currentAllowanceLabel.setText("");
                currentAllowanceLabel.setText("Allowance set aside each month: " + allowance);
                currentAllowanceAlert.setText("");
            }
            else {
                currentAllowanceAlert.setText("Please enter a sum to set aside each month.");
            }
        }
    }
    private class nextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            balance += allowance;

            while (!wishes.isEmpty() && wishes.peek().getCost() < balance) {
                Item temp = wishes.getFirst();
                while (temp != null && temp.getCost() < balance) {
                    balance -= temp.getCost();

                    itemBought += temp.getDescription() + " has been purchased for $" + temp.getCost() + ", ";

                    wishes.remove();

                    itemBoughtLabel.setText("");
                    itemBoughtLabel.setText(itemBought);

                    if (wishes.peek() != null) temp = wishes.getFirst();
                    else temp = null;
                }
                itemBought = "";
            }
            currentBalanceLabel.setText("");
            currentBalanceLabel.setText("Current Balance: " + balance);

            month++;
            if (month > 12) month = 1;

            currentMonth = returnMonth(month);
            currentMonthLabel.setText("Current Month: " + currentMonth);
        }
    }
    private class itemButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (!itemNameField.getText().trim().equals("") && !itemCostField.getText().trim().equals("")) {
                Item buyThis = new Item(itemNameField.getText().trim(), Integer.parseInt(itemCostField.getText()));
                wishes.add(buyThis);
                itemNameField.setText("");
                itemCostField.setText("");
                confirmationLabel.setText("Got it!");
            }
            else {
                confirmationLabel.setText("Please enter valid input for the item description and cost.");
            }
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