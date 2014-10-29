//*********************************************************
// VoteCounterGUI.java  
//
// Demonstrates a graphical user interface and event listeners to
// tally votes for two candidates, Joe and Sue.
// Modified by Robert Gammelgaard 10/25/2012
//*********************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VoteCounterGUI
{
    private int WIDTH = 300;
    private int HEIGHT = 40;
    private int votesForJoe;
    private int votesForSue;
    private JFrame frame;
    private JPanel panel;
    private JButton sue;
    private JLabel labelSue;
    private JButton joe;
    private JLabel labelJoe;

    //----------------------------------------------
    // Constructor: Sets up the GUI.
    //----------------------------------------------
    public VoteCounterGUI()
    {
        votesForJoe = 0;
        votesForSue = 0;
        frame = new JFrame ("Vote Counter");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        joe = new JButton("Vote for Joe");
        joe.addActionListener(new JoeButtonListener());
        sue = new JButton("Vote for Sue");
        sue.addActionListener(new SueButtonListener());

        labelJoe = new JLabel("Votes for Joe: " + votesForJoe);
        labelSue = new JLabel("Votes for Sue: " + votesForSue);
        panel = new JPanel();
        panel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
        panel.setBackground (Color.blue);
        panel.add(joe);
        panel.add(labelJoe);
        panel.add(sue);
        panel.add(labelSue);
        panel.add(new drawStuff());
        frame.getContentPane().add (panel,BorderLayout.LINE_START);
        frame.getContentPane().add (new drawStuff());
    }
    //-----------------------------------------------------------------
    //  Displays the primary application frame.
    //-----------------------------------------------------------------
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    }
    //***************************************************
    // Represents a listener for button push (action) events
    //***************************************************
    private class JoeButtonListener implements ActionListener
    {
        //----------------------------------------------
        // Updates the counter and label when Vote for Joe 
        // button is pushed
        //----------------------------------------------
        public void actionPerformed(ActionEvent event)
        {
            votesForJoe++;
            labelJoe.setText("Votes for Joe: " + votesForJoe);
        }
    }
    private class SueButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            votesForSue++;
            labelSue.setText("Votes for Sue: " + votesForSue);
        }
    }
    private class drawStuff extends JComponent
    {
        drawStuff() {}

        public void paint(Graphics g)
        {
            int width = getWidth();
            int height = getHeight();
            int fillDegree = (int) (360.0 * votesForJoe / (votesForJoe + votesForSue));
            createCircle(fillDegree,g);
            g.setColor(Color.black);
            g.drawOval(width/2 - 250,height/2 - 250,500,500);
            
            if (votesForJoe>votesForSue)
            {
                g.drawString("Joe is ahead!",(int)(width * (2/3.))+100,height/2);
            }
            else if (votesForJoe<votesForSue)
            {
                g.drawString("Sue is ahead!",(int)(width * (2/3.))+100,height/2);
            }
            else
            {
                g.drawString("Tied!",(int)(width * (2/3.))+100,height/2);
            }
            
            repaint();
        }

        void createCircle(int fill, Graphics g)
        {
            int w = getWidth();
            int h = getHeight();

            g.setColor(Color.cyan);
            g.fillArc(w/2 - 250,h/2 - 250,500,500,90,fill);
        }
    }
}