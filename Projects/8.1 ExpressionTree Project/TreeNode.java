//********************************************************************
//  TreeNode.java       Author: AP* Committee, comments added by
//                              Lewis/Loftus/Cocking
//
//  A node in a binary tree.
//********************************************************************


public class TreeNode
{
   private Object value;
   private TreeNode left;
   private TreeNode right;

   //-----------------------------------------------------------------
   //  Initializes this node.
   //-----------------------------------------------------------------
   public TreeNode (Object initValue, TreeNode initLeft, TreeNode initRight)
   {
      value = initValue;
      left = initLeft;
      right = initRight;
   }

   //-----------------------------------------------------------------
   //  Returns the value of this node.
   //-----------------------------------------------------------------
   public Object getValue()
   {
      return value;
   }

   //-----------------------------------------------------------------
   //  Returns the left child of this node.
   //-----------------------------------------------------------------
   public TreeNode getLeft()
   {
      return left;
   }

   //-----------------------------------------------------------------
   //  Returns the right child of this node.
   //-----------------------------------------------------------------
   public TreeNode getRight()
   {
      return right;
   }
   //-----------------------------------------------------------------
   //  Sets the value of this node.
   //-----------------------------------------------------------------
   public void setValue(Object theNewValue)
   {
      value = theNewValue;
   }

   //-----------------------------------------------------------------
   //  Sets the left child of this node.
   //-----------------------------------------------------------------
   public void setLeft(TreeNode theNewLeft)
   {
      left = theNewLeft;
   }

   //-----------------------------------------------------------------
   //  Sets the right child of this node.
   //-----------------------------------------------------------------
   public void setRight(TreeNode theNewRight)
   {
      right = theNewRight;
   }
} 