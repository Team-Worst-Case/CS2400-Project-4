import org.junit.Test;
import org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class  JUnit
{
    public void testOptimalInMaxHeapMethod() {

        Integer[] testValues = {10,20,30,40,50,80}; // change to our desired values if need be
        MaxHeap<Integer> optimalHeap = new MaxHeap<>(testValues);

        Integer[] testResult = new Integer[5];

        for (int index = 0; index < optimalHeap.getSize(); index++) {

            testResult[index-1] = optimalHeap.getMax(); // might be wrong with 'getMax'
        }

        // Create expectedResult from scratch
        Integer[] expectedResult = {50, 20, 80, 40, 10, 30};

        assertArrayEquals(expectedResult, testResult);
    }

    public void testSequentialMethod() {

        //Create test values for heap test
        //Integer[] testValues = {10,20,30,40,50,80};
        MaxHeap<Integer> sequentialHeap = new MaxHeap<>();
        for (int i = 0; i < 100; i++) sequentialHeap.add(i);

        Integer[] testResult = new Integer[5];

        for (int index = 0; index < sequentialHeap.getSize(); index++) {

            testResult[index-1] = sequentialHeap.getMax();
        }

        // Create expectedResult from scratch
        Integer[] expectedResult = {50, 20, 80, 40, 10, 30};

        // Created Heap should match expected Heap using sequential method
        assertArrayEquals(expectedResult, testResult);
        
    }

    public void testRemoveMaxMethod() {
        
        //Create test values for heap test
        Integer[] removeValue = {100,94,99,77,93,98,61,68,76,84};

        MaxHeap<Integer> currentHeap = new MaxHeap<>(removeValue);
        currentHeap.removeMax();

        Integer[] testResult = new Integer[currentHeap.getSize()];

        for (int index = 1; index < currentHeap.getSize() +1; index++)
        {
            testResult[index-1] = currentHeap.getMax();
        }

        // Create expected outcome form current made Heap
        Integer[] expectedResult = {77}; // should be 100? returning max heap

        assertArrayEquals(expectedResult, testResult);
    }
}