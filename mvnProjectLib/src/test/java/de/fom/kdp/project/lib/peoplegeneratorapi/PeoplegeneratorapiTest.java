package de.fom.kdp.project.lib.peoplegeneratorapi;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.fom.kdp.project.lib.json.DecodeJson;

/**
 * test for Peoplegeneratorapi
 * 
 * @author engels
 *
 */
public class PeoplegeneratorapiTest {

	@Test
	public void testGetPeople() throws IOException, InterruptedException {
//		Thread.sleep(1000); // waiting - not to fast repeat requests for api
		int anzahl = 2;
		String jsonPeople = Peoplegeneratorapi.getPeople(anzahl);
		if (jsonPeople != null) {

			JsonArray jsonArray = JsonParser.parseString(jsonPeople).getAsJsonArray();

			assertEquals(anzahl, jsonArray.size()); // is count of datasets okay?

			for (JsonElement jsonElement : jsonArray) {

				if (jsonElement.isJsonObject()) {
					JsonObject jsonObject = jsonElement.getAsJsonObject();
					DecodeJson.generateClassFromJson(jsonObject);

				}
				System.out.println("-----------------------");
			}
		} else {
			System.err.println("keine Daten vom Server ");
		}
	}

	@Test
	public void testGetElemHashtable() throws IOException, InterruptedException {

		String jsonPeople = Peoplegeneratorapi.getPeople(2);
		if (jsonPeople != null) {
			JsonArray jsonArray = JsonParser.parseString(jsonPeople).getAsJsonArray();
			for (JsonElement jsonElement : jsonArray) {

				if (jsonElement.isJsonObject()) {
//			countPeople++;
					JsonObject jsonObject = jsonElement.getAsJsonObject();
					// DecodeJson.generateClassFromJson(jsonObject);
					Hashtable<String, Object> keyValuePairs = DecodeJson.getElemHAshSet(jsonObject);

					// Print the key-value pairs
					for (Map.Entry<String, Object> entry : keyValuePairs.entrySet()) {
						System.out.println(entry.getKey() + ":" + entry.getValue());
					}
				}
			}
		} else {
			System.err.println("keine Daten vom Server ");
		}

	}

}
