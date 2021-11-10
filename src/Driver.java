import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileWriter;

public class Driver
{
	public static void main(String[] args) throws IOException
	{
		FileWriter file = new FileWriter("output.txt");
		file.write("Heap built using optimal method (sorted data): ");
		heapFromFile("src/data_sorted.txt", file);
		
		file.write("\n");
		file.write("Heap built using optimal method (random data): ");
		heapFromFile("src/data_random.txt", file);

		file.close();
	}

	public static void heapFromFile(String fileName, FileWriter file) throws IOException
	{
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);

		MaxHeap mHeap = new MaxHeap(100);

		while (scnr.hasNext()) {
			int num = scnr.nextInt();
			mHeap.add(num);
		}
		scnr.close();

		mHeap.writeToFile(file);
		file.write("\n");
		file.write("Number of swaps in the heap creation: " + mHeap.getSwaps());
		file.write("\n");
		file.write("Heap after 10 removals: ");
		for (int i = 0; i < 10; i++) mHeap.removeMax();
		mHeap.writeToFile(file);
		file.write("\n");
	}
}