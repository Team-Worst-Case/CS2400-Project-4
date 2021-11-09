import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Driver
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Sorted data:");
		fileRead("src/data_sorted.txt");
		
		System.out.println("Sorted random:");
		fileRead("src/data_random.txt");
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
}