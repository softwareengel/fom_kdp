package de.fom.kdp.skript.kap3;

public class A3_3ML {
    public static void main(String[] args) {
        // Step 1: Implement a one-dimensional String array of size 3
        String[] names = {"Alice", "Bob", "Charlie"};

        // Step 2: Output the first letter of the first element followed by a period
        System.out.println(names[0].charAt(0) + ".");

        // Step 3: Output the number of characters in the second element
        System.out.println(names[1].length());

        // Step 4: Output the third element completely in uppercase
        System.out.println(names[2].toUpperCase());

        // Step 5: Concatenate the three names and output in lowercase
        String concatenatedNames = names[0] + names[1] + names[2];
        System.out.println(concatenatedNames.toLowerCase());
    }
}
