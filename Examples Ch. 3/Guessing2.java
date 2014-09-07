//********************************************************************
//  Guessing.java       Author: Lewis/Loftus/Cocking
//  Revised by Robert Gammelgaard
//  Date 9/6/12
//  Added AP approved random numbers using Math.random() instead of java.util.Random
//  Demonstrates the use of a block statement in an if-else.
//********************************************************************
import java.util.Scanner;
public class Guessing2
{
   //-----------------------------------------------------------------
   //  Plays a simple guessing game with the user.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      final int MAX = 10;
      int answer, guess;
      Scanner scan = new Scanner (System.in);
      answer = (int)(Math.random()*MAX) + 1;
      System.out.print ("I'm thinking of a number between 1 and "
                        + MAX + ". Guess what it is: ");
      guess = scan.nextInt();
      if (guess == answer)
         System.out.println ("You got it! Good guessing!");
      else
      {
         System.out.println ("That is not correct, sorry.");
         System.out.println ("The number was " + answer);
      }
   }
}