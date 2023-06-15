package de.fom.kdp.project.lib.example.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;

public class HashtableExample {
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
