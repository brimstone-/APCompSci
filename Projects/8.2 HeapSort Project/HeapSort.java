//********************************************************************
//  HeapSort.java       Author: Lewis/Loftus/Cocking
//
//  Sort an array of characters using heapsort.
//********************************************************************

public class HeapSort
{
   //-----------------------------------------------------------------
   //  Sorts an array of characters using heapsort.
   //-----------------------------------------------------------------
   public static void heapsort (char[] data)
   {
      HeapOfCharacters heap = new HeapOfCharacters();

      // Add the characters to the heap.
      for (char c : data)
      {
         heap.add(c);
      }

      // Remove the characters from the heap in sorted order
      // and put them back into the array.
      for (int i = 0; i < data.length; i++)
      {
         data[i] = heap.removeRoot();
      }
   }
}
