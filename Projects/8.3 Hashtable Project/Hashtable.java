//Listing 10.9
//********************************************************************
//  Hashtable.java       Author: Lewis/Loftus/Cocking
//
//  Implements a hashtable using chaining to handle collisions.
//********************************************************************


public class Hashtable
{
   private int size;
   private ListNode[] table;
   

   //-----------------------------------------------------------------
   //  Sets up an empty hashtable with the given size.
   //-----------------------------------------------------------------
   public Hashtable (int numSlots)
   {
      size = numSlots;
      table = new ListNode[size];
   }

   //-----------------------------------------------------------------
   //  Adds an element to the hashtable.
   //-----------------------------------------------------------------
   public void add (Object obj)
   {
      //  Create a node for the given element
      ListNode element = new ListNode(obj, null);

      //  Calculate the hash code
      int index = obj.hashCode() % size;

      //  Add the element to the appropriate cell, using chaining
      if (table[index] == null)
         table[index] = element;
      else
      {
         ListNode current = table[index];
         element.setNext(current);
         table[index] = element;
      }
   }

   //-----------------------------------------------------------------
   //  Returns a string representation of this hashtable.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String str = "";

      for (int i=0; i < size; i++)
      {
         str += i + ": ";
         ListNode current = table[i];
         while (current != null)
         {
            str += current.getValue() + " ";
            current = current.getNext();
         }
         str += "\n";
      }

      return str;
   }
} 