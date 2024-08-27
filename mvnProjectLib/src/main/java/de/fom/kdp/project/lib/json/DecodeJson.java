package de.fom.kdp.project.lib.json;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * The {@code DecodeJson} class provides utility methods for processing and
 * decoding JSON objects. It includes methods for generating Java class fields
 * from a JSON object and for converting a JSON object into a {@code Hashtable}
 * of key-value pairs.
 *
 * <p>
 * This class is useful for dynamically handling JSON data, extracting fields,
 * and converting JSON structures into more manageable Java data types.
 * </p>
 * 
 * @author engels
 */

public class DecodeJson {
//	public static void main(String[] args) throws IOException, InterruptedException {
//		String json = "{\"name\":\"Shari Toy\",\"age\":1,\"job\":\"Student\",\"incomeUSD\":0,\"creditScore\":0,\"ccNumber\":null,\"married\":false,\"hasChildren\":false,\"height\":155.0,\"weight\":65.5,\"eyeColor\":\"GRAY\",\"email\":\"sharitoy@gmail.com\",\"gender\":\"Female\",\"hasDegree\":true,\"bloodType\":\"B+\",\"username\":\"shari51\",\"politicalLeaning\":0.07,\"religion\":\"Hinduism\",\"address\":{\"streetAddress\":\"2113 Kesha Road\",\"city\":\"Việt Trì\",\"state\":\"Hòa Bình\",\"country\":\"Vietnam\",\"zip\":\"2241\",\"geonameId\":1563926,\"phoneNumber\":\"+84 9548324390\",\"ipAddress\":\"194.202.128.22\",\"countryCode\":\"VN\"},\"doB\":\"Thu May 18 04:00:43 UTC 2023\",\"gpa\":0.0}";
//		// json = Peoplegeneratorapi.getPeople(1);
//		Gson gson = new Gson();
//		JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
//		if (jsonElement.isJsonObject()) {
//			JsonObject jsonObject = jsonElement.getAsJsonObject();
//			generateClassFromJson(jsonObject);
//		}
//	}
	/**
	 * Recursively generates Java class fields from the structure of a
	 * {@code JsonObject}.
	 * 
	 * <p>
	 * This method iterates through the entries of the provided {@code JsonObject}
	 * and prints out Java class field declarations based on the types of the JSON
	 * elements. It handles nested JSON objects, primitive fields, and arrays.
	 * </p>
	 *
	 * @param jsonObject the {@code JsonObject} from which to generate class fields.
	 */
	public static void generateClassFromJson(JsonObject jsonObject) {
		Iterator<Map.Entry<String, JsonElement>> iterator = jsonObject.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, JsonElement> entry = iterator.next();
			String fieldName = entry.getKey();
			JsonElement fieldValue = entry.getValue();

			if (fieldValue.isJsonObject()) {
				// Nested object
				JsonObject nestedObject = fieldValue.getAsJsonObject();
				generateClassFromJson(nestedObject);
			} else if (fieldValue.isJsonPrimitive()) {
				// Primitive field
				String fieldType = fieldValue.getAsJsonPrimitive().getAsString();
				System.out.println("private " + fieldType + " " + fieldName + ";");
			} else if (fieldValue.isJsonArray()) {
				// Array field
				String arrayType = fieldValue.getAsJsonArray().get(0).getClass().getSimpleName();
				System.out.println("private " + arrayType + "[] " + fieldName + ";");
			}
		}
	}

	/**
	 * Produces a {@code Hashtable} of key-value pairs from the provided
	 * {@code JsonObject}.
	 * 
	 * <p>
	 * This method iterates over the entries of the {@code JsonObject} and stores
	 * each key-value pair in a {@code Hashtable}. The keys are the field names, and
	 * the values are the corresponding JSON elements.
	 * </p>
	 * 
	 * @param jsonObject the {@code JsonObject} from which to extract key-value
	 *                   pairs.
	 * @return a {@code Hashtable} containing the key-value pairs from the JSON
	 *         object.
	 */
	public static Hashtable<String, Object> getElemHAshSet(JsonObject jsonObject) {
		Hashtable<String, Object> keyValuePairs = new Hashtable<>();
		// for (int i = 0; i < jsonArray.size(); i++) {
		// JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

		// Iterate over the key-value pairs in each JSON object
		for (Map.Entry<String, com.google.gson.JsonElement> entry : jsonObject.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			keyValuePairs.put(key, value);
		}
		// }
		return keyValuePairs;

	}
}
