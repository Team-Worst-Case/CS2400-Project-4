import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
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
   private int swaps = 0;
   
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
	   this (entries.length); // Call other constructor
	   assert integrityOK = true;
      lastIndex = entries.length;
	   
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
            swaps++;
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

   public int getSwaps()
   {
      return swaps;
   }

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

   // Throws an exception if this object is not initialized.
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("MaxHeap object is corrupt.");
   }
   
   //Throws an exception if capacity is above maximum
   private void checkCapacity(int newLength)
   {
      if (newLength > MAX_CAPACITY)
         throw new IllegalStateException("Attempted to create heap with capacity greater than " + MAX_CAPACITY);
   }
   
   private void ensureCapacity()
   {
      if (lastIndex >= heap.length - 1) // If heap is full, double its size
      {
         int newLength = 2 * heap.length;
         checkCapacity(newLength);
         heap = Arrays.copyOf(heap, newLength);
      }
   }

   public void writeToFile(FileWriter file) throws IOException
   {
      /**for (int i = 0; i <= lastIndex / 2; i++)
         //System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i + 1] + " RIGHT CHILD :" + heap[2 * i + 2] + "\n");
         file.write(heap[i].toString() + "," + heap[2 * i + 1].toString() + "," + heap[2 * i + 2].toString() + ",");*/
      for (int i = 1; i <= lastIndex; i++) {
         String content = String.valueOf(heap[i]) + ",";
			file.write(content);
      }
   }
   
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
		   if (rightChildIndex <= lastIndex && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
			{
				largerChildIndex = rightChildIndex;
         }

         if (orphan.compareTo(heap[largerChildIndex]) < 0)
         {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
            swaps++;
			}
			else
				done = true;
	  }
	  heap[rootIndex] = orphan;
   }
} // end MaxHeap