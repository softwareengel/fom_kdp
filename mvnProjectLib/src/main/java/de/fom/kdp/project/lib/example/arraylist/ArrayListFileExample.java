package de.fom.kdp.project.lib.example.arraylist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * In this example, we create an ArrayList called myList and add some elements
 * to it. We then write the myList object to a file named "list.ser" using
 * ObjectOutputStream. To read the ArrayList from the file, we use
 * ObjectInputStream and cast the retrieved object to an
 * ArrayList&lt;String&gt;.
 *
 * Please note that when using ObjectOutputStream and ObjectInputStream, the
 * objects being written and read must be serializable. In this example, we
 * assume that the elements in the ArrayList are of type String, which is
 * serializable by default. If you're working with custom objects, make sure
 * they implement the Serializable interface.
 *
 * Remember to handle any potential exceptions that may occur during the file
 * operations.
 *
 * @author engels
 *
 */
public class ArrayListFileExample {
	/**
	 * The entry point of the application. This method demonstrates various
	 * operations on ArrayLists reading/writing to file
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Hello");
		myList.add("World");
		myList.add("OpenAI");

		// Write ArrayList to file
		try {
			FileOutputStream fileOut = new FileOutputStream("list.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(myList);
			objectOut.close();
			System.out.println("ArrayList written to file successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read ArrayList from file
		try {
			FileInputStream fileIn = new FileInputStream("list.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			ArrayList<String> readList = (ArrayList<String>) objectIn.readObject();
			objectIn.close();

			System.out.println("ArrayList read from file:");
			for (String item : readList) {
				System.out.println(item);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
