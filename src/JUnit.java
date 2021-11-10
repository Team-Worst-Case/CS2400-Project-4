import org.junit.Test;
import org.mockito.Mockito.*;
import static org.junit.Assert.*;





public class  JUnit
{
    public void testOptimalMaxHeapMethod {
        Integer[] testValues = {10,20,30,40,50,80};
        MaxHeap<Integer> optimalHeap = new MaxHeap<>();
        optimalHeap.MaxHeap(testValues);

        for (int index = 0; index < optimalHeap.getSize(); index++) {

            result[index-1] = optimalHeap.getMax(index);
        }

        expected = {50, 20, 80, 40, 10, 30};
    }


    public void testSequentialMethod {

    }
}