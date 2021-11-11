import org.junit.Test;
import static org.junit.Assert.*;

public class  JUnit
{
	@Test
	public void test1() {
		MaxHeap testHeap = new MaxHeap(5);
		assertEquals(null, testHeap.getMax());
	}

	@Test
	public void test2() {
		MaxHeap testHeap = new MaxHeap(5);
		testHeap.add(3);
		testHeap.add(6);
		testHeap.add(8);
		testHeap.add(4);
		testHeap.add(5);
		assertEquals(5, testHeap.getSize());
	}

	@Test
	public void test3() {
		MaxHeap testHeap = new MaxHeap(5);
		testHeap.add(2);
		testHeap.add(4);
		testHeap.add(6);
		testHeap.add(4);
		testHeap.add(5);
		assertEquals(6, testHeap.getMax());
	}


	@Test
    public void testOptimalInMaxHeapMethod() {
        Integer[] testValues = {10,20,30,40,50,80}; // change to our desired values if need be
        MaxHeap<Integer> optimalHeap = new MaxHeap<>(testValues);

        Integer[] testResult = new Integer[6];

        for (int index = 1; index < optimalHeap.getSize()+1; index++) {
            testResult[index] = optimalHeap.getMax(); // might be wrong with 'getMax'
        }

        // Create expectedResult from scratch
        Integer[] expectedResult = {50, 20, 80, 40, 10, 30};

        assertArrayEquals(expectedResult, testResult);
    }

    @Test
    public void testSequentialMethod() {

        //Create test values for heap test
        //Integer[] testValues = {10,20,30,40,50,80};
        MaxHeap<Integer> sequentialHeap = new MaxHeap<>();
        for (int i = 0; i < 5; i++) sequentialHeap.add(i);

        Integer[] testResult = new Integer[sequentialHeap.getSize()];

        for (int index = 1; index < sequentialHeap.getSize(); index++) {
            testResult[index] = sequentialHeap.getMax();
        }

        // Create expectedResult from scratch
        Integer[] expectedResult = {5, 2, 4, 1, 3};

        // Created Heap should match expected Heap using sequential method
        assertArrayEquals(expectedResult, testResult);
        
    }

    @Test
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