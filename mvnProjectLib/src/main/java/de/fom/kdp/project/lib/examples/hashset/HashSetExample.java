package de.fom.kdp.project.lib.examples.hashset;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
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
