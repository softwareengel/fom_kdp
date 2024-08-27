package de.fom.kdp.project.lib.example.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
/**
 * The {@code HashSetExample} class provides a demonstration of basic operations using the {@code HashSet} class in Java.
 * This example highlights the key features and behaviors of a {@code HashSet}, such as storing unique elements,
 * maintaining an unordered collection, and performing common operations like adding, removing, and checking for
 * the presence of elements.
 * 
 * <p>Specifically, this class includes the following examples:</p>
 * 
 * <ul>
 *   <li><b>String HashSet Example:</b> 
 *   Demonstrates the creation of a {@code HashSet} to store strings. The example shows how to:
 *     <ul>
 *       <li>Add elements ("Apple," "Banana," "Orange") to the set.</li>
 *       <li>Print the set, displaying elements in no specific order due to the unordered nature of {@code HashSet}.</li>
 *       <li>Check if specific elements (e.g., "Apple" and "Grapes") are present in the set, with results showing whether they are found.</li>
 *     </ul>
 *   </li>
 *   
 *   <li><b>Integer HashSet Example:</b> 
 *   Demonstrates the creation of a {@code HashSet} to store integers. The example shows how to:
 *     <ul>
 *       <li>Add elements (10, 20, 30, 40) to the set.</li>
 *       <li>Use an {@code Iterator} to traverse and print each element in the set.</li>
 *       <li>Remove a specific element (e.g., 20) from the set and print the remaining elements.</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * <p>The {@code HashSetExample} class serves as a practical guide to understanding how to use {@code HashSet} in Java
 * for managing collections of unique elements, and it illustrates the non-sequential order in which elements are stored and accessed.</p>
 * @author engels
 *
 */
public class HashTableExample {
	/**
	 * The entry point of the application.
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	public static void main(String[] args) {
		// Create a Hashtable to store key-value pairs of integers and strings
		Hashtable<Integer, String> hashtable = new Hashtable<>();

		// Add elements to the Hashtable
		hashtable.put(1, "One");
		hashtable.put(2, "Two");
		hashtable.put(3, "Three");

		// Print the Hashtable
		System.out.println(hashtable); // Output: {3=Three, 2=Two, 1=One}

		// Iterate over the Hashtable using Enumeration
		Enumeration<Integer> keys = hashtable.keys();
		while (keys.hasMoreElements()) {
			Integer key = keys.nextElement();
			String value = hashtable.get(key);
			System.out.println("Key: " + key + ", Value: " + value);
		}

		for (Entry<Integer, String> entry : hashtable.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + ", Value: " + value);
		}

		// Access elements in the Hashtable
		System.out.println(hashtable.get(1)); // Output: One
		System.out.println(hashtable.get(2)); // Output: Two
		System.out.println(hashtable.get(3)); // Output: Three

		// Create a Hashtable to store key-value pairs of strings and integers
		Hashtable<String, Integer> hashtableInt = new Hashtable<>();

		// Add elements to the Hashtable
		hashtableInt.put("One", 1);
		hashtableInt.put("Two", 2);
		hashtableInt.put("Three", 3);

		// Remove an element from the Hashtable
		hashtableInt.remove("Two");

		// Print the Hashtable
		System.out.println(hashtableInt); // Output: {Three=3, One=1}

		// Create a Hashtable to store key-value pairs of strings and booleans
		Hashtable<String, Boolean> hashtableKV = new Hashtable<>();

		// Add elements to the Hashtable
		hashtableKV.put("Apple", true);
		hashtableKV.put("Banana", true);
		hashtableKV.put("Orange", false);

		// Check if a key exists in the Hashtable
		boolean containsApple = hashtableKV.containsKey("Apple");
		System.out.println("Contains Apple? " + containsApple); // Output: Contains Apple? true

		boolean containsGrapes = hashtableKV.containsKey("Grapes");
		System.out.println("Contains Grapes? " + containsGrapes); // Output: Contains Grapes? false

	}

}
