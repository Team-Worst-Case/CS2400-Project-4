
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class Driver
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("test");

		int hundredInts[] = new int[100];

		try {

			int i = 0;
			File inputFile = new File("data.txt");
			Scanner scnr = new Scanner(inputFile);

			while (scnr.hasNextLine()) {
				hundredInts[i++] = scnr.nextInt();
			}

			scnr.close();
		}
	}
}