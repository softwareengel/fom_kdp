package de.fom.kdp.project.lib.example.random;

import java.util.Random;

/**
 * This example demonstrates generating random integers and doubles using
 * different random number generators.
 * 
 * @author engels
 *
 */
public class RandomNumers {
	/**
	 * The entry point of the application.
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	
	public static void main(String[] args) {
		Random random = new Random();
		float randomNumber = random.nextFloat();

		System.out.println("Random Number: " + randomNumber);

		int randomInt = random.nextInt(100); // Random integer between 0 and 99
		double randomDouble = random.nextDouble(); // Random double between 0.0 and 1.0
		System.out.println("Random Integer: " + randomInt);
		System.out.println("Random Double: " + randomDouble);
	}
}
