package de.fom.kdp.project.lib.example.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
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
