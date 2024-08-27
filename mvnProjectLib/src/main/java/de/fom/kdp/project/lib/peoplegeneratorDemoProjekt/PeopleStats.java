package de.fom.kdp.project.lib.peoplegeneratorDemoProjekt;

import java.util.Hashtable;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.fom.kdp.project.lib.json.DecodeJson;

/**
 * The {@code PeopleStats} class processes JSON data representing people,
 * extracts relevant information, and calculates basic statistics such as the
 * total count of people and the sum and average of their ages.
 * 
 * <p>
 * This class is designed to parse JSON data, count the number of people, and
 * aggregate their ages for statistical analysis. It uses the {@code DecodeJson}
 * utility to extract key-value pairs from the JSON objects.
 * </p>
 * 
 * <p>
 * <strong>Note:</strong> This class is marked as {@link Deprecated} and may be
 * removed or replaced in future versions.
 * </p>
 * 
 * @author engels
 * @deprecated This class is deprecated and may be removed or replaced in future
 *             versions.
 */
@Deprecated
public class PeopleStats {
	int countPeople = 0;
	float sumAge = 0;

	/**
	 * Constructs a {@code PeopleStats} object by processing the provided JSON
	 * string.
	 * 
	 * <p>
	 * The constructor parses the JSON data, counts the number of people, and sums
	 * their ages. The data is expected to be in a JSON array format where each
	 * element represents a person.
	 * </p>
	 * 
	 * @param json the JSON string containing data about people.
	 */
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

	/**
	 * Prints the calculated statistics to the console.
	 * 
	 * <p>
	 * This method outputs the total number of people, the sum of their ages, and
	 * the average age calculated from the provided data.
	 * </p>
	 */
	public void printStat() {
		System.out.println("------STATISTIC -----------");
		System.out.println("countPeople: " + countPeople);
		System.out.println("sumAge: " + sumAge);
		System.out.println("avgAge: " + sumAge / countPeople);

	}

}
