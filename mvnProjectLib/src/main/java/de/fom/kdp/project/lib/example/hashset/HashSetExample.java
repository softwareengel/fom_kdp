package de.fom.kdp.project.lib.example.hashset;

import java.util.HashSet;
import java.util.Iterator;

/**

 * The {@code HashSetExample} class demonstrates basic operations using Java's {@code HashSet} class.
 * It covers several key functionalities, including adding, removing, checking for elements, and 
 * iterating through elements in a set.
 * 
 * <p>This class provides two main examples:</p>
 * 
 * <ul>
 *   <li><b>String HashSet:</b>
 *     <ul>
 *       <li>A {@code HashSet} named {@code set} is created to store strings.</li>
 *       <li>Elements ("Apple," "Banana," "Orange") are added to the set.</li>
 *       <li>The set is printed, showing the elements in no particular order due to the unordered nature of {@code HashSet}.</li>
 *       <li>The program checks if the set contains specific elements ("Apple" and "Grapes"), printing {@code true} for "Apple" and {@code false} for "Grapes".</li>
 *     </ul>
 *   </li>
 *   <li><b>Integer HashSet:</b>
 *     <ul>
 *       <li>A {@code HashSet} named {@code setInt} is created to store integers.</li>
 *       <li>Elements (10, 20, 30, 40) are added to the set.</li>
 *       <li>An {@code Iterator} is used to loop through and print each element in the set.</li>
 *       <li>The element 20 is removed from the set, and the updated set is printed, showing the remaining elements.</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * <p>The examples highlight the unordered and unique nature of sets in Java.</p>
 * @author engels
 *
 */
public class HashSetExample {
	/**
	 * The entry point of the application.
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	public static void main(String[] args) {
		// Create a HashSet to store strings
		HashSet<String> set = new HashSet<>();

		// Add elements to the HashSet
		set.add("Apple");
		set.add("Banana");
		set.add("Orange");

		// Print the HashSet
		System.out.println(set); // Output: [Apple, Orange, Banana]
		// Create a HashSet to store strings

		// Check if the HashSet contains an element
		boolean containsApple = set.contains("Apple");
		System.out.println("Contains Apple? " + containsApple); // Output: Contains Apple? true

		boolean containsGrapes = set.contains("Grapes");
		System.out.println("Contains Grapes? " + containsGrapes); // Output: Contains Grapes? false

		// Create a HashSet to store integers
		HashSet<Integer> setInt = new HashSet<>();

		// Add elements to the HashSet
		setInt.add(10);
		setInt.add(20);
		setInt.add(30);
		setInt.add(40);

		Iterator<Integer> iterator = setInt.iterator();
		while (iterator.hasNext()) {
			int element = iterator.next();
			System.out.println(element);
		}

		// Remove an element from the HashSet
		setInt.remove(20);

		// Print the HashSet
		System.out.println(setInt); // Output: [40, 10, 30]

	}
}
