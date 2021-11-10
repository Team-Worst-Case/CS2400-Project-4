import org.junit.Test;
import org.mockito.Mockito.*;
import static org.junit.Assert.*;




public class  JUnit
{
    public void testOptimalMaxHeapMethod {
        Integer[] testValues = {10,20,30,40,50,80}; // change to our desired values if need be
        MaxHeap<Integer> optimalHeap = new MaxHeap<>();
        optimalHeap.MaxHeap(testValues);

        Integer[] testResult = new Integer[5];

        for (int index = 0; index < optimalHeap.getSize(); index++) {

            testResult[index-1] = optimalHeap.getMax(index); // might be wrong with 'getMax'
        }

        Integer[] expectedResult = {50, 20, 80, 40, 10, 30};

        assertArrayEquals(expectedResult, testResult);
    }


    public void testSequentialMethod {
        // Almost the same thing as optimal method, just need to change a couple things
        /*
        Integer[] testValues = {10,20,30,40,50,80};
        MaxHeap<Integer> optimalHeap = new MaxHeap<>();
        optimalHeap.MaxHeap(testValues);

        Integer[] testResult = new Integer[5];

        for (int index = 0; index < optimalHeap.getSize(); index++) {

            testResult[index-1] = optimalHeap.getMax(index);
        }

        Integer[] expectedResult = {50, 20, 80, 40, 10, 30};

        assertArrayEquals(expectedResult, testResult);
        */
    }

    public void testRemoveMaxMethod {
        //TBA

    }

    public void testAddMethod {
        //TBA

    }
}