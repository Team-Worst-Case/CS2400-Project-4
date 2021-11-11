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

	public <T> T[] fileToArray(String fileName, FileWriter file) throws IOException {
		Path path = Paths.get(fileName);
		Scanner scnr = new Scanner(path);
		
		

		while (scnr.hasNextLine())
		{
			
		}

		//make array
		class MyArray<T> {
			private Object[] T;
		
			MyArray() {
				this.T = new Object[1];
			}
		
			T get(int index) {
				return (T) T[index];
			}
		
			void set(int index, T value) {
				T[index] = value;
			}
		} 
		
		for (int i = 0; i < index.length; i++) {
				T[i] = 
			
		   }

		while (scnr.hasNext()) {
			int content = scnr.nextInt();
			//add to array
		}
		scnr.close();

		//return array
		return intArray;
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