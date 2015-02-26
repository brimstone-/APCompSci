//Listing 10.10
//********************************************************************
//  ListNode.java       Author: AP* Committee, comments added by
//                              Lewis/Loftus/Cocking
//
//  A node in a linked list.
//********************************************************************

public class ListNode
{
   private Object value;
   private ListNode next;

   //-----------------------------------------------------------------
   //  Initializes this node.
   //-----------------------------------------------------------------
   public ListNode (Object initValue, ListNode initNext)
   {
      value = initValue;
      next = initNext;
   }
   //-----------------------------------------------------------------
   //  Returns the value of this node.
   //-----------------------------------------------------------------
   public Object getValue ()
   {
      return value;
   }

   //-----------------------------------------------------------------
   //  Returns the next reference in this node.
   //-----------------------------------------------------------------
   public ListNode getNext ()
   {
      return next;
   }

   //-----------------------------------------------------------------
   //  Sets the value of this node.
   //-----------------------------------------------------------------
   public void setValue (Object theNewValue)
   {
      value = theNewValue;
   }

   //-----------------------------------------------------------------
   //  Sets the next reference in this node.
   //-----------------------------------------------------------------
   public void setNext (ListNode theNewNext)
   {
      next = theNewNext;
   }
} 