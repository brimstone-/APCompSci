//Listing 10.8
//********************************************************************
//  HashTest.java       Author: Lewis/Loftus/Cocking
//
//  Driver for testing a hashtable.
//********************************************************************

public class HashTest
{
   //-----------------------------------------------------------------
   //  Creates a hashtable of size 7, adds numbers to it, then
   //  prints it out.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      Hashtable table = new Hashtable(7);

      table.add(new Integer(36));
      table.add(new Integer(15));
      table.add(new Integer(23));
      table.add(new Integer(26));
      table.add(new Integer(5));
      table.add(new Integer(40));

      System.out.println (table);
   }
} 