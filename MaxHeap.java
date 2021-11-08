import java.util.Arrays;
/**
   A class that implements the ADT maxheap by using an array.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class MaxHeap<T extends Comparable<? super T>>
             implements MaxHeapInterface<T>
{
   private T[] heap;      // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private boolean integrityOK = false;
   private static final int DEFAULT_CAPACITY = 25;
   private static final int MAX_CAPACITY = 10000;
   
   public MaxHeap()
   {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor
   
   public MaxHeap(int initialCapacity)
   {
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      integrityOK = true;
   } // end constructor
   
   public MaxHeap(T[] entries)
   {
	   this (entries.length) // Call other constructor
	   assert integrityOK = true;
	   
	   //Copy given array to data field
	   for (int index = 0; index < entries.length; index++)
		   heap[index + 1] = entries[index];
	   
	   //Create heap
	   for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
		   reheap(rootIndex);
   }

   public void add(T newEntry)
   {
   		checkIntegrity();
   		int newIndex = lastIndex + 1;
   		int parentIndex = newIndex / 2;
   		while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
   		{
   			heap[newIndex] = heap[parentIndex];
   			newIndex = parentIndex;
   			parentIndex = newIndex / 2;
   		}
   		heap[newIndex] = newEntry;
   		lastIndex++;
   		ensureCapacity();
   } // end add

   public T removeMax()
   {
	   checkIntegrity();
	   T root = null;
	   
	   if (!isEmpty())
	   {
		   root = heap[1];
		   heap[1] = heap[lastIndex];
		   lastIndex--;
		   reheap(1);
	   }
	   return root;
   } // end removeMax

   public T getMax()
   {
		checkIntegrity();
      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   } // end getMax

   public boolean isEmpty()
   {
      return lastIndex < 1;
   } // end isEmpty

   public int getSize()
   {
      return lastIndex;
   } // end getSize

   public void clear()
   {
	   checkIntegrity();
	   while (lastIndex > -1)
	   {
		   heap[lastIndex] = null;
		   lastIndex--;
	   } // end while
      lastIndex = 0;
   } // end clear
   
// Private methods
// . . .
   private void reheap (int rootIndex)
   {
	   boolean done = false;
	   T orphan = heap[rootIndex];
	   int leftChildIndex = 2 * rootIndex;
	   
	   while (!done && (leftChildIndex <= lastIndex))
	   {
		   int largerChildIndex = leftChildIndex; //Assume larger
		   int rightChildIndex = leftChildIndex + 1;
		   if (rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
			{
				heap[rootIndex] = heap[larherChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
			}
			else
				done = true;
	  }
	  heap[rootIndex] = orphan;
   }
} // end MaxHeap