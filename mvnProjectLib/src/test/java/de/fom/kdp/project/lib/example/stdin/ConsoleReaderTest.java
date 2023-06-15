package de.fom.kdp.project.lib.example.stdin;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import de.fom.kdp.project.lib.consoleReader.ConsoleReader;

/**
 * test for Scanner in ConsoleReader
 *
 * @author engels
 *
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
	 * @author engels
	 *
	 */
	public class ByteArrayInputStream extends InputStream {
		private byte[] buffer;
		private int position;

		public ByteArrayInputStream(byte[] buffer) {
			this.buffer = buffer;
			this.position = 0;
		}

		@Override
		public int read() throws IOException {
			if (position >= buffer.length) {
				return -1; // end of stream
			}
			return buffer[position++];
		}
	}

	@Test
	public void testReadString() {
		// Simulating user input of "hello"
		String input = "hello";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		String s = ConsoleReader.readString();
		assertEquals(input, s);
	}

	@Test
	public void testReadInt() {
		// Simulating user input of "1"
		String input = "1";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		int i = ConsoleReader.readInt();
		assertEquals(input, "" + i);
	}

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
