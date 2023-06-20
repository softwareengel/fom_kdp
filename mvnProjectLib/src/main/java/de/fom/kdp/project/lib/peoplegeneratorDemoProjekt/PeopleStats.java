package de.fom.kdp.project.lib.peoplegeneratorDemoProjekt;

import java.util.Hashtable;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.fom.kdp.project.lib.json.DecodeJson;

public class PeopleStats {
	int countPeople = 0;
	float sumAge = 0;

	public PeopleStats(String json) {
		JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
		for (JsonElement jsonElement : jsonArray) {

			if (jsonElement.isJsonObject()) {
				countPeople++;
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				// DecodeJson.generateClassFromJson(jsonObject);
				Hashtable<String, Object> keyValuePairs = DecodeJson.getElemHAshSet(jsonObject);

				// Print the key-value pairs
				for (Map.Entry<String, Object> entry : keyValuePairs.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + ":" + value);
					switch (key) {
					// religion, incomeUSD, gender "Male", height, weight
					case "age":
						sumAge = sumAge + Integer.parseInt(value.toString());
						break;
					case "religion":
//						sumAge = sumAge + Integer.parseInt(value.toString());
						break;						
					default:
						break;
					}

				}
			}
		}
	}

	public void printStat() {
		System.out.println("------STATISTIC -----------");
		System.out.println("countPeople: " + countPeople);
		System.out.println("sumAge: " + sumAge);
		System.out.println("avgAge: " + sumAge / countPeople);

	}

}
