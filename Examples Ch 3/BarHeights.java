//********************************************************************
//  BarHeights.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of conditionals and loops to guide drawing.
//********************************************************************
import java.applet.Applet;
import java.awt.*;
import java.util.Random;
public class BarHeights extends Applet
{
   //-----------------------------------------------------------------
   //  Paints bars of varying heights, tracking the tallest and
   //  shortest bars, which are redrawn in color at the end.
   //-----------------------------------------------------------------
   public void paint (Graphics page)
   {
      final int NUM_BARS = 10, WIDTH = 30, MAX_HEIGHT = 300, GAP =9;
      int tallX = 0, tallest = 0, shortX = 0, shortest = MAX_HEIGHT;
      int x, height;
      Random generator = new Random();
      setBackground (Color.black);
      page.setColor (Color.blue);
      x = GAP;
      for (int count = 0; count < NUM_BARS; count++)
      {
         height = generator.nextInt(MAX_HEIGHT) + 1;
         page.fillRect (x, MAX_HEIGHT-height, WIDTH, height);
         //  Keep track of the tallest and shortest bars
         if (height > tallest)
         {
            tallX = x;
            tallest = height;
         }
         if (height < shortest)
         {
            shortX = x;
            shortest = height;
         }
         x = x + WIDTH + GAP;
      }
      //  Redraw the tallest bar in red
      page.setColor (Color.red);
      page.fillRect (tallX, MAX_HEIGHT-tallest, WIDTH, tallest);
      //  Redraw the shortest bar in yellow
      page.setColor (Color.yellow);
      page.fillRect (shortX, MAX_HEIGHT-shortest, WIDTH, shortest);
   }
}