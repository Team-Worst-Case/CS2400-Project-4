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
	}

	/*public <T> T[] fileToArray(String fileName, FileWriter file) throws IOException {
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);
		
		int i = 0;

		int content[] = new int [10];

		T[] potato;

		T[1] = 0;


		while (scnr.hasNextLine())
		{
			potato.add(scnr.nextInt());
		}
		
		for (int j = 0; j < index.length; j++) {
				T[j] = 
			
		   }

		while (scnr.hasNext()) {
			T content = scnr.nextInt();
			//add to array
		}

		scnr.close();

		//return array
		return potato;
	}
	*/

	public int[] fileToArray(String fileName, FileWriter file) throws IOException {
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);
		
		int array[] = new int[10];
		int i = 0;
		
		while (scnr.hasNextLine())
		{
			array[i] = scnr.nextInt();
			i++;
		}
		
		scnr.close();

		//return array
		return array;
	}

	public static void heapFromFile(String fileName, FileWriter file) throws IOException
	{
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);

		MaxHeap mHeap = new MaxHeap(100);

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