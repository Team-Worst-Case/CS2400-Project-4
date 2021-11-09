/**import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Driver
{
	public void main(String[] args)
	{
		fileRead("data_random");
		

		MaxHeap mHeap = new MaxHeap(15);
                        
		mHeap.add(5);
		System.out.println(mHeap.getMax());
		mHeap.add(3);
		System.out.println(mHeap.getMax());
		mHeap.add(17);
		System.out.println(mHeap.getMax());
		mHeap.add(10);
		System.out.println(mHeap.getMax());
		mHeap.add(84);
		System.out.println(mHeap.getMax());
		mHeap.add(19);
		System.out.println(mHeap.getMax());
		mHeap.add(6);
		System.out.println(mHeap.getMax());
		mHeap.add(22);
		System.out.println(mHeap.getMax());
		mHeap.add(9);
		System.out.println(mHeap.getMax());
	}

	public void fileRead(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner scnr = new Scanner(inputFile);

		int [] hundredInts = new int[101];
		int i = 0;

		while (scnr.hasNext()) {
			hundredInts [i+1] = scnr.nextInt();
			i++;
		}
		scnr.close();
	}
} */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.net.*;
//import java.io.*;

public class Driver
{
	public static void main(String[] args) throws FileNotFoundException
	{
		URL path = Driver.class.getResource("data_sorted.txt");
		File inputFile = new File(path.getFile());
		//Reader reader = new BufferedReader(new FileReader(f));

		//File inputFile = new File("data_sorted.txt");
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