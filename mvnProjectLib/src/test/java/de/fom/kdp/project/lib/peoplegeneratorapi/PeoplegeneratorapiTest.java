package de.fom.kdp.project.lib.peoplegeneratorapi;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.google.gson.Gson;
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


		JsonArray jsonArray = JsonParser.parseString(jsonPeople).getAsJsonArray();
		
		assertEquals(anzahl, jsonArray.size()); // is count of datasets okay? 
		
		for (JsonElement jsonElement : jsonArray) {

			if (jsonElement.isJsonObject()) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				DecodeJson.generateClassFromJson(jsonObject);

			}
			System.out.println("-----------------------");
		}
	}

//	@Test
//	public void testMain() {
//		try {
//			Peoplegeneratorapi.main(null);
//		} catch (IOException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
