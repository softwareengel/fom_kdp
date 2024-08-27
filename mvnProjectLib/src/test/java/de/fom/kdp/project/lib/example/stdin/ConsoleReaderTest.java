package de.fom.kdp.project.lib.example.stdin;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import de.fom.kdp.project.lib.stdin.ConsoleReader;

/**
 * Test class for {@link ConsoleReader}.
 * <p>
 * This class contains unit tests to verify the functionality of the
 * {@link ConsoleReader} class. It simulates user input via a custom
 * {@link ByteArrayInputStream} class to test the different input reading
 * methods provided by {@link ConsoleReader}.
 * </p>
 * <p>
 * The tests cover the reading of strings, integers, floats, and doubles from
 * the console input.
 * </p>
 * 
 * @see ConsoleReader
 */
public class ConsoleReaderTest {
	/**
	 * ByteArrayInputStream is a class in Java that provides an implementation of an
	 * input stream backed by an internal byte array. It allows you to read data
	 * from a byte array as if you were reading from an input stream.
	 *
	 * The ByteArrayInputStream class is useful when you have data stored in a byte
	 * array and need to read it as an input stream, which is especially handy in
	 * cases where other code expects an InputStream interface.
	 * 
	 * A custom {@link InputStream} implementation that simulates input from a byte
	 * array.
	 * <p>
	 * This class allows the tests to simulate user input by providing data as an
	 * input stream that can be read by the {@link ConsoleReader} methods.
	 * </p>
	 * 
	 * @author engels
	 *
	 */
	public class ByteArrayInputStream extends InputStream {
		private byte[] buffer;
		private int position;

		/**
		 * Constructs a new {@link ByteArrayInputStream} with the specified byte array
		 * as the source of the input stream.
		 * 
		 * @param buffer the byte array to be used as the input source
		 */
		public ByteArrayInputStream(byte[] buffer) {
			this.buffer = buffer;
			this.position = 0;
		}

		/**
		 * Reads the next byte of data from the input stream. Returns -1 if the end of
		 * the stream has been reached.
		 * 
		 * @return the next byte of data, or -1 if the end of the stream has been
		 *         reached
		 * @throws IOException if an I/O error occurs
		 */
		@Override
		public int read() throws IOException {
			if (position >= buffer.length) {
				return -1; // end of stream
			}
			return buffer[position++];
		}
	}

	/**
	 * Tests the {@link ConsoleReader#readString()} method.
	 * <p>
	 * This test simulates user input of a string and verifies that the
	 * {@link ConsoleReader} correctly reads and returns the input string.
	 * </p>
	 */
	@Test
	public void testReadString() {
		// Simulating user input of "hello"
		String input = "hello";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		String s = ConsoleReader.readString();
		assertEquals(input, s);
	}

	/**
	 * Tests the {@link ConsoleReader#readInt()} method.
	 * <p>
	 * This test simulates user input of an integer and verifies that the
	 * {@link ConsoleReader} correctly reads and returns the input integer.
	 * </p>
	 */
	@Test
	public void testReadInt() {
		// Simulating user input of "1"
		String input = "1";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		int i = ConsoleReader.readInt();
		assertEquals(input, "" + i);
	}

	/**
	 * Tests the {@link ConsoleReader#readFloat()} method.
	 * <p>
	 * This test simulates user input of a float and verifies that the
	 * {@link ConsoleReader} correctly reads and returns the input float.
	 * </p>
	 */
	@Test
	public void testReadFloat() {
		// Simulating user input of "1.0"
		// String input = "1,0"; // Locale DE
		String input = "1.0";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		float f = ConsoleReader.readFloat();

		assertEquals(Float.parseFloat(input), f, 0); // compare float with delta
	}

	/**
	 * Tests the {@link ConsoleReader#readDouble()} method.
	 * <p>
	 * This test simulates user input of a double and verifies that the
	 * {@link ConsoleReader} correctly reads and returns the input double.
	 * </p>
	 */
	@Test
	public void testReadDouble() {
		// Simulating user input of "1.0"
		// String input = "1,0"; // Locale DE
		String input = "1.0";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		double d = ConsoleReader.readDouble();

		assertEquals(Double.parseDouble(input), d, 0); // compare float with delta
	}

}
