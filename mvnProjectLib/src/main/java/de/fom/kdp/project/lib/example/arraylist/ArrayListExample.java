package de.fom.kdp.project.lib.example.arraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Simple ArrayList Example The ArrayListExample class demonstrates basic
 * operations using Java's ArrayList class. The program performs several tasks:
 * 
 * Creating and Manipulating an Integer ArrayList: An ArrayList named numbers is
 * created to store integers. Elements (10, 20, 30) are added to the list. The
 * list is printed, showing [10, 20, 30]. The element at index 1 (value 20) is
 * removed, and the list is printed again, showing [10, 30]. All elements are
 * removed, and new elements (5, 2, 8, 1, 4) are added. The list is sorted in
 * ascending order and printed, showing [1, 2, 4, 5, 8].
 * 
 * Creating and Accessing a String ArrayList: Another ArrayList named fruits is
 * created to store strings. Elements ("Apple," "Banana," "Orange") are added.
 * Elements are accessed and printed by index, displaying "Apple," "Banana," and
 * "Orange." The program checks if "Apple" is present in the list, printing
 * true.
 * 
 * Overall, this class provides a simple example of using ArrayList for basic
 * operations such as adding, removing, sorting, accessing, and checking the
 * existence of elements.
 * 
 * @author engels
 *
 */
public class ArrayListExample {
	/**
	 * The entry point of the application. This method demonstrates various
	 * operations on ArrayLists, including adding, removing, sorting, and accessing
	 * elements.
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	public static void main(String[] args) {
		// Create an ArrayList to store integers
		ArrayList<Integer> numbers = new ArrayList<>();

		// Add elements to the ArrayList
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);

		// Print the ArrayList
		System.out.println(numbers); // Output: [10, 20, 30]

		// Remove elements from the ArrayList
		numbers.remove(1); // Remove the element at index 1

		// Print the ArrayList
		System.out.println(numbers); // Output: [10, 30, 40]

		numbers.removeAll(numbers);
		numbers.add(5);
		numbers.add(2);
		numbers.add(8);
		numbers.add(1);
		numbers.add(4);

		// Sort the ArrayList in ascending order
		Collections.sort(numbers);

		// Print the sorted ArrayList
		System.out.println(numbers); // Output: [1, 2, 4, 5, 8]

		// Create an ArrayList to store strings
		ArrayList<String> fruits = new ArrayList<>();

		// Add elements to the ArrayList
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");

		// Access elements in the ArrayList
		System.out.println(fruits.get(0)); // Output: Apple
		System.out.println(fruits.get(1)); // Output: Banana
		System.out.println(fruits.get(2)); // Output: Orange

		// Check if the ArrayList contains an element
		boolean containsRed = fruits.contains("Apple");
		System.out.println("Contains Apple? " + containsRed); // Output: Contains Red? true

	}
}
