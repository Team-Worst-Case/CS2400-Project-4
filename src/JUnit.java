import org.junit.Test;
import static org.junit.Assert.*;

public class  JUnit
{
	@Test
	public void test1() {
		MaxHeap<Integer> testHeap = new MaxHeap<>();
		assertEquals(null, testHeap.getMax());
	}

	@Test
	public void test2() {
		MaxHeap<Integer> testHeap = new MaxHeap<>();
		testHeap.add(3);
		testHeap.add(6);
		testHeap.add(8);
		testHeap.add(4);
		testHeap.add(5);
		assertEquals(5, testHeap.getSize());
	}

	@Test
	public void test3() {
		MaxHeap<Integer> testHeap = new MaxHeap<>();
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
        MaxHeap<Integer> optimalHeap = new MaxHeap<>();
        optimalHeap.add(2);
        optimalHeap.add(4);
        optimalHeap.add(6);
        optimalHeap.add(4);
        optimalHeap.add(5);

        Integer[] testResult = new Integer[6];

        for (int index = 1; index <= optimalHeap.getSize(); index++) {
            testResult[index] = optimalHeap.getMax(); // might be wrong with 'getMax'
            optimalHeap.removeMax();
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

    public void newTestSequentialMethod() {
        Integer[] grabFromThis = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16} ;
        MaxHeap<Integer> expected = new MaxHeap<>();

        for (int i=0; i<grabFromThis.length; ++i) 
        {
            expected.add(grabFromThis[i]);
        }

        MaxHeap<Integer> testSequen = new MaxHeap<>();

        testSequen.add(grabFromThis);
        assertEquals(expected.getMax(), testSequen.getMax());
        
        while (expected.getSize() > 0) {
            assertEquals(expected.removeMax(), testSequen.removeMax());
        }
 
    }

    @Test
    public void newTestOptimalMethods() {
        Integer[] testOptimal = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32};
        MaxHeap<Integer> expected = new MaxHeap<>(testOptimal);
        MaxHeap<Integer> optiHeap = new MaxHeap<>();
        optiHeap.MaxHeap(testOptimal);

        assertEquals(expected.getMax(), optiHeap.getMax());

        while (expected.getSize() > 0) {
            assertEquals(expected.removeMax(), optiHeap.removeMax());
        }
 
    }
}
    
