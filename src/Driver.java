import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Driver
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Sorted data:");
		heapRead("src/data_sorted.txt");

		System.out.println("\n");

		System.out.println("Random data:");
		heapRead("src/data_random.txt");
	}

	public static void fileRead(String fileName) throws IOException
	{
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);

		MaxHeap mHeap = new MaxHeap(100);
		while (scnr.hasNext()) {
			int num = scnr.nextInt();
			mHeap.add(num);
			System.out.println(num);
		}
		scnr.close();
	}

	public static void heapRead(String fileName) throws IOException
	{
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);

		MaxHeap mHeap = new MaxHeap(100);
		while (scnr.hasNext()) {
			int num = scnr.nextInt();
			mHeap.add(num);
		}
		scnr.close();
		
		mHeap.print();

		System.out.println("after 10 removals: ");
		for (int i = 0; i < 10; i++) {
			mHeap.removeMax();
		}
		mHeap.print();

		System.out.println("Swaps: " + mHeap.getSwaps());
	}
}