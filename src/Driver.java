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

		file.write("Sorted Data\n");
		heapFromFile("src/data_sorted.txt", file);
		file.write("\n");
		file.write("Random Data\n");
		heapFromFile("src/data_random.txt", file);
		/*file.write("\n");
		heapFromFile("src/data_letters.txt", file);*/

		file.close();
	}

	public static Integer[] fileToArray(Scanner scnr) throws IOException {
		Integer array[] = new Integer[100];
		Integer i = 0;
		
		while (scnr.hasNextLine() && i < 100)
		{
			array[i] = scnr.nextInt();
			i++;
		}
		
		return array;
	}

	public static void heapFromFile(String fileName, FileWriter file) throws IOException
	{
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);

		Integer[] heapArr = new Integer[100];
		heapArr = fileToArray(scnr);
		MaxHeap mHeapOpti = new MaxHeap(heapArr);
		
		file.write("Heap built using optimal method: ");
		mHeapOpti.writeToFile(file);
		file.write("\n");
		
		file.write("Number of swaps in the heap creation: " + mHeapOpti.getSwaps());
		file.write("\n");

		for (int i = 0; i < 10; i++) mHeapOpti.removeMax();
		file.write("Heap after 10 removals: ");
		mHeapOpti.writeToFile(file);
		file.write("\n\n");

		scnr = new Scanner(path);
		MaxHeap mHeapSeq = new MaxHeap(100);

		while (scnr.hasNext()) {
			//String content = scnr.next();
			int content = scnr.nextInt();
			mHeapSeq.add(content);
		}
		scnr.close();

		file.write("Heap built using sequential method: ");
		mHeapSeq.writeToFile(file);
		file.write("\n");
		
		file.write("Number of swaps in the heap creation: " + mHeapSeq.getSwaps());
		file.write("\n");

		for (int i = 0; i < 10; i++) mHeapSeq.removeMax();
		file.write("Heap after 10 removals: ");
		mHeapSeq.writeToFile(file);
		file.write("\n\n");
	}
}