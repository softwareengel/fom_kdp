package de.fom.kdp.project.lib.example.random;

import java.util.Random;

/**
 * The {@code RandomNumers} class demonstrates generating random integers,
 * floats, and doubles using the {@link Random} class. It includes methods for
 * generating random numbers with or without a seed, allowing for reproducible
 * sequences of random numbers.
 * <p>
 * This example covers basic usage of the {@link Random} class to produce random
 * numbers and illustrates how to set a seed to generate consistent results
 * across runs.
 * </p>
 * 
 * @author engels
 */
public class RandomNumers {
	/**
	 * A static {@link Random} instance used for generating random numbers in this
	 * class. It is initialized with a random seed by default.
	 */
	static Random random = randSeed();

	/**
	 * The entry point of the application.
	 * <p>
	 * This method demonstrates the generation of random integers, floats, and
	 * doubles, both with and without a specified seed. It prints the results to the
	 * console to show the output of each random number generator.
	 * </p>
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	public static void main(String[] args) {

		int randomInt = randInt();
		System.out.println("Random Integer: " + randomInt);

		float randomNumber = randFloat();
		System.out.println("Random Number: " + randomNumber);

		double randomDouble = randDouble();
		System.out.println("Random Double: " + randomDouble);

		RandomNumers.randSeed(222);

		randomInt = randInt();
		System.out.println("Random Integer: " + randomInt); // 71

		randomNumber = randFloat();
		System.out.println("Random Number: " + randomNumber); // 0.99918574

		randomDouble = randDouble();
		System.out.println("Random Double: " + randomDouble); // 0.37242867841906147
	}

	/**
	 * Generates a random double between 0.0 (inclusive) and 1.0 (exclusive).
	 * 
	 * @return a random double value between 0.0 and 1.0
	 */
	public static double randDouble() {

		double randomDouble = random.nextDouble(); // Random double between 0.0 and 1.0
		return randomDouble;
	}

	/**
	 * Generates a random integer between 0 (inclusive) and 100 (exclusive).
	 * 
	 * @return a random integer value between 0 and 99
	 */
	public static int randInt() {

		int randomInt = random.nextInt(100); // Random integer between 0 and 99
		return randomInt;
	}

	/**
	 * Sets the static {@link Random} instance to a new one initialized with the
	 * specified seed.
	 * <p>
	 * Using a seed allows for the generation of a reproducible sequence of random
	 * numbers.
	 * </p>
	 * 
	 * @param seed the seed to initialize the random number generator
	 * @return the {@link Random} instance initialized with the specified seed
	 */
	public static Random randSeed(long seed) {
		random = new Random(seed);
		return random;
	}

	/**
	 * Sets the static {@link Random} instance to a new one initialized with a
	 * randomly chosen seed.
	 * 
	 * @return the {@link Random} instance initialized with a random seed
	 */
	public static Random randSeed() {
		random = new Random();
		return random;
	}

	/**
	 * Generates a random float between 0.0 (inclusive) and 1.0 (exclusive).
	 * 
	 * @return a random float value between 0.0 and 1.0
	 */
	public static float randFloat() {

		float randomNumber = random.nextFloat();
		return randomNumber;
	}
}
