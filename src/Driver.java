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
		
		/*file.write("\n");
		file.write("Heap built using optimal method (letters data): ");
		heapFromFile("src/data_letters.txt", file);*/

		file.close();
		
		//test for joseph
		/*Integer test[] = new Integer[10];

		test = fileToArray("data_random.txt");

		for(int i = 0; i < 10; i ++)
		{
			System.out.println(test[i]);
		}*/
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

		MaxHeap mHeap = new MaxHeap(100);
		Integer[] heapArr = new Integer[100];

		heapArr = fileToArray(scnr);

		MaxHeap mHeap2 = new MaxHeap(heapArr);

		while (scnr.hasNext()) {
			//String content = scnr.next();
			int content = scnr.nextInt();
			mHeap.add(content);
		}
		scnr.close();

		mHeap.writeToFile(file);
		file.write("\n");
		
		file.write("Number of swaps in the heap creation: " + mHeap.getSwaps());
		file.write("\n");

		for (int i = 0; i < 10; i++) mHeap.removeMax();
		file.write("Heap after 10 removals: ");
		mHeap.writeToFile(file);
		file.write("\n");
	}
}