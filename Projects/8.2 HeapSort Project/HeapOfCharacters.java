//Listing 10.7
//********************************************************************
//  HeapOfCharacters.java       Author: Lewis/Loftus/Cocking
//
//  Implements a heap of characters.
//********************************************************************

import java.util.ArrayList;

public class HeapOfCharacters {
	private ArrayList<Character> heap;

	//-----------------------------------------------------------------
	//  Sets up an empty heap.
	//-----------------------------------------------------------------
	public HeapOfCharacters () {
		heap = new ArrayList<Character>();
		heap.add(null); // add a "dummy" element in position 0
	}

	//-----------------------------------------------------------------
	//  Returns a string representing this heap.
	//-----------------------------------------------------------------
	public String toString () {
		return heap.toString();
	}

	//-----------------------------------------------------------------
	//  Adds an element to the heap.
	//-----------------------------------------------------------------
	public void add (Character ch) {
		heap.add(ch);
		bubbleUp();
	}

	public char removeRoot() {
		Character lastChar = heap.remove(heap.size() - 1);
		if (heap.size() == 1) {
			return lastChar;
		} else {
			Character oldRoot = heap.remove(1);
			heap.add(1, lastChar);
			bubbleDown();
			return oldRoot;
		}
	}

	public void bubbleDown() {
		int swapIndex = 1;
		int curIndex = 1;

		int childIndex1;
		int childIndex2;

		childIndex1 = curIndex * 2;
		childIndex2 = curIndex * 2 + 1;

		Character cur = heap.get(curIndex);

		while (childIndex1 < heap.size() && cur.compareTo(heap.get(childIndex1)) > 0) {
			swapIndex = -1;
			if (childIndex2 < heap.size()) {
				Character child1 = heap.get(childIndex1);
				Character child2 = heap.get(childIndex2);

				if (child1.compareTo(child2) < 0) {
					swapIndex = childIndex1;
				} else {
					swapIndex = childIndex2;
				}
			} else if (cur.compareTo(heap.get(childIndex1)) > 0) {
				swapIndex = childIndex1;
			}
			if (swapIndex != -1) {
				Character child = heap.get(swapIndex);
				heap.set(swapIndex, cur);
				heap.set(curIndex, child);

				curIndex = swapIndex;
				childIndex1 = curIndex * 2;
				childIndex2 = curIndex * 2 + 1;
			}
		}
	}
	//-----------------------------------------------------------------
	//  Bubbles the last element up as necessary to preserve
	//  the ordering of the heap.
	//-----------------------------------------------------------------
	private void bubbleUp () {
		int curIndex = heap.size() - 1;
		int parentIndex = curIndex / 2;
		Character cur = heap.get(curIndex);

		while ((curIndex > 1) && (cur.compareTo(heap.get(parentIndex)) < 0)) {
			// Swap current element with its parent
			Character parent = heap.get(parentIndex);
			heap.set(parentIndex, cur);
			heap.set(curIndex, parent);

			curIndex = parentIndex;
			parentIndex = curIndex / 2;
		}
	}
}