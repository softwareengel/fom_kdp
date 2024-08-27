package de.fom.kdp.project.lib.assertions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

/**
 * A test class demonstrating various assertions available in JUnit.
 * <p>
 * This class provides examples of using assertions to validate conditions
 * during testing, ensuring that the expected and actual results match. The
 * examples cover simple assertions as well as more complex assertions involving
 * floating-point comparisons and custom objects.
 * </p>
 * 
 * @author engels
 *
 */
public class AssertionExamplesTest {
	/**
	 * Demonstrates various basic assertions in JUnit.
	 * <p>
	 * This method tests:
	 * <ul>
	 * <li>Equality and inequality of strings</li>
	 * <li>Boolean conditions (true and false)</li>
	 * <li>Null and non-null object references</li>
	 * <li>Reference equality and inequality</li>
	 * <li>Array and iterable equality</li>
	 * </ul>

	 */
	@Test
	public void testAssertions() {
		// Assert equals
		assertEquals("failure - strings are not equal", "text", "text");

		// Assert not equals
		assertNotEquals("failure - strings should not be equal", "text", "different");

		// Assert true
		assertTrue("failure - should be true", 5 > 4);

		// Assert false
		assertFalse("failure - should be false", 5 < 4);

		// Assert null
		assertNull("failure - should be null", null);

		// Assert not null
		assertNotNull("failure - should not be null", new Object());

		// Assert same (checks if two references point to the same object)
		String str = "test";
		assertSame("failure - should be same", str, str);

		// Assert not same (checks if two references point to different objects)
		assertNotSame("failure - should not be same", str, new String("test"));

		// Assert array equals
		int[] expectedArray = { 1, 2, 3 };
		int[] resultArray = { 1, 2, 3 };
		assertArrayEquals("failure - arrays are not equal", expectedArray, resultArray);

		// Assert iterable equals
		List<String> expectedList = Arrays.asList("one", "two", "three");
		List<String> resultList = Arrays.asList("one", "two", "three");
		assertEquals("failure - lists are not equal", expectedList, resultList);

		// Assert condition fails (useful for marking test failure deliberately)
		// fail("failure - this is a deliberate failure");
	}

	/**
	 * Demonstrates more complex assertions, including floating-point comparison and
	 * custom object equality.
	 * <p>
	 * This method tests:
	 * <ul>
	 * <li>Floating-point number comparison with a delta to handle precision</li>
	 * <li>Equality of custom objects (requires properly implemented equals
	 * method)</li>
	 * </ul>

	 */
	@Test
	public void testComplexAssertions() {
		// Assert floating point numbers (with a delta to handle precision)
		assertEquals("failure - floats are not equal", 1.0f, 1.01f, 0.02);

		// Assert complex object equals (requires properly implemented equals method)
		Person person1 = new Person("John", 25);
		Person person2 = new Person("John", 25);
		assertEquals("failure - persons are not equal", person1, person2);
	}

	/**
	 * A simple class representing a person with a name and age.
	 * <p>
	 * This class is used to demonstrate the need for a properly implemented
	 * {@link #equals(Object)} and {@link #hashCode()} methods for custom objects in
	 * assertions.
	 * </p>
	 */
	class Person {
		private String name;
		private int age;

		/**
		 * Constructs a new Person with the specified name and age.
		 * 
		 * @param name the name of the person
		 * @param age  the age of the person
		 */
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		/**
		 * Compares this person to the specified object. The result is true if and only
		 * if the argument is not null and is a {@code Person} object that has the same
		 * name and age as this object.
		 * 
		 * @param obj the object to compare this {@code Person} against
		 * @return {@code true} if the given object represents a {@code Person}
		 *         equivalent to this person, {@code false} otherwise
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;
			Person person = (Person) obj;
			return age == person.age && name.equals(person.name);
		}

		/**
		 * Returns a hash code value for the person. This method is supported for the
		 * benefit of hash tables such as those provided by {@link java.util.HashMap}.
		 * 
		 * @return a hash code value for this object
		 */
		@Override
		public int hashCode() {
			return Objects.hash(name, age);
		}
	}
}
