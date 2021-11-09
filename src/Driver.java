
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class Driver
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File inputFile = new File("data_sorted.txt");
		Scanner scnr = new Scanner(inputFile);

		int [] hundredInts = new int[101];
		int i = 0;

		while (scnr.hasNext()) {
			hundredInts [i+1] = scnr.nextInt();
			i++;
		}
		scnr.close();
	}
}