package de.fom.kdp.ProjektX;

/**
 * The {@code A} class represents a node in a linked structure where each
 * instance can point to another instance of {@code A}. This allows for the
 * creation of various linked data structures such as linked lists. Each
 * instance also contains an integer value.
 * 
 * <p>
 * The class provides methods to get and set the integer value and the reference
 * to the next {@code A} instance in the sequence.
 * </p>
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * A first = new A();
 * first.setI(10);
 * A second = new A();
 * second.setI(20);
 * first.setNextA(second);
 * </pre>
 * 
 * 
 * @author engels
 * @version 1.0
 */
public class A {
	/**
	 * Reference to the next {@code A} instance in the sequence.
	 */
	A nextA;
	/**
	 * An integer value associated with this instance of {@code A}.
	 */
	int i;

	/**
	 * Gets the integer value associated with this instance.
	 * 
	 * @return the integer value of {@code i}
	 */
	public int getI() {
		return i;
	}

	/**
	 * Sets the integer value for this instance.
	 * 
	 * @param i the integer value to set
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * Gets the reference to the next {@code A} instance in the sequence.
	 * 
	 * @return the next {@code A} instance, or {@code null} if there is none
	 */
	public A getNextA() {
		return nextA;
	}

	/**
	 * Sets the reference to the next {@code A} instance in the sequence.
	 * 
	 * @param nextA the next {@code A} instance to reference
	 */
	public void setNextA(A nextA) {
		this.nextA = nextA;
	}

	/**
	 * The main method, serves as an entry point to the program. Currently, it only
	 * prints a message indicating a successful execution.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		System.out.println("Plausibles Eingabe-, Verarbeitungs- und Ergebnis-Protokoll");

	}
}
