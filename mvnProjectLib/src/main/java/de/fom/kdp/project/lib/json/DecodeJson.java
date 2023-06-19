package de.fom.kdp.project.lib.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.fom.kdp.project.lib.peoplegeneratorapi.Peoplegeneratorapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

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
}
