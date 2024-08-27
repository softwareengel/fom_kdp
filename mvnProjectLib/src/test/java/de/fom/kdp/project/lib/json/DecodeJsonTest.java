package de.fom.kdp.project.lib.json;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 
 * Unit test class for the {@link DecodeJson} class.
 * <p>
 * This class contains a test method to ensure that the main method of the
 * {@link DecodeJson} class runs without throwing any exceptions.
 * </p>
 * 
 * <p>
 * This test simulates running the {@code DecodeJson.main} method with a null
 * argument, similar to typical usage where no command-line arguments are
 * provided.
 * </p>
 * 
 * <p>
 * The test passes if the method completes without throwing any
 * {@code IOException} or {@code InterruptedException}.
 * </p>
 * 
 * <p>
 * Note: Since this test executes the main method, it may produce console output
 * depending on the implementation of the {@code DecodeJson.main} method.
 * </p>
 * 
 * @author engels
 *
 */
public class DecodeJsonTest {
	/**
	 * Tests the {@link DecodeJson#main(String[])} method.
	 * <p>
	 * This test ensures that the main method can be executed without any
	 * exceptions, verifying that the basic functionality of the {@link DecodeJson}
	 * class is working as expected.
	 * </p>
	 *
	 * @throws IOException          if an I/O error occurs during the execution of
	 *                              the main method
	 * @throws InterruptedException if the execution of the main method is
	 *                              interrupted
	 */
	@Test
	public void testMain() throws IOException, InterruptedException {
		DecodeJson.main(null);
	}

	/**
	 * Tests the {@link DecodeJson#getElemHAshSet(JsonObject)} method.
	 * <p>
	 * This test verifies that the JSON object is correctly converted into a
	 * hashtable of key-value pairs and prints each pair to the console.
	 * </p>
	 * <p>
	 * The test uses a sample JSON string representing a person's details, converts
	 * it into a JSON object, and then calls the
	 * {@link DecodeJson#getElemHAshSet(JsonObject)} method to extract and display
	 * the key-value pairs.
	 * </p>
	 *
	 * @throws IOException          if an I/O error occurs during the processing of
	 *                              the JSON object.
	 * @throws InterruptedException if the test execution is interrupted.
	 */
	@Test
	public void testGetElemHashtable() throws IOException, InterruptedException {
		String jsonPeople = "{\"name\":\"Shari Toy\",\"age\":1,\"job\":\"Student\",\"incomeUSD\":0,\"creditScore\":0,\"ccNumber\":null,\"married\":false,\"hasChildren\":false,\"height\":155.0,\"weight\":65.5,\"eyeColor\":\"GRAY\",\"email\":\"sharitoy@gmail.com\",\"gender\":\"Female\",\"hasDegree\":true,\"bloodType\":\"B+\",\"username\":\"shari51\",\"politicalLeaning\":0.07,\"religion\":\"Hinduism\",\"address\":{\"streetAddress\":\"2113 Kesha Road\",\"city\":\"Việt Trì\",\"state\":\"Hòa Bình\",\"country\":\"Vietnam\",\"zip\":\"2241\",\"geonameId\":1563926,\"phoneNumber\":\"+84 9548324390\",\"ipAddress\":\"194.202.128.22\",\"countryCode\":\"VN\"},\"doB\":\"Thu May 18 04:00:43 UTC 2023\",\"gpa\":0.0}";
		Gson gson = new Gson();
		JsonElement jsonElement = gson.fromJson(jsonPeople, JsonElement.class);

		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			Hashtable<String, Object> keyValuePairs = DecodeJson.getElemHAshSet(jsonObject);
			// Print the key-value pairs
			for (Map.Entry<String, Object> entry : keyValuePairs.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}

		}

	}
}
