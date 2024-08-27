package de.fom.kdp.project.lib.alphavantage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.TreeMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * A client for interacting with the Alpha Vantage API to retrieve stock market
 * data.
 * <p>
 * This class provides methods to fetch historical stock data and save it to a
 * file.
 * </p>
 * 
 * ####################### API KEY BENÖTIGT ##########################
 * 
 * @author engels
 */
public class AlphaVantageClient {

	private static final String BASE_URL = "https://www.alphavantage.co/query?";
	private final String apiKey;

	/**
	 * Constructs an {@code AlphaVantageClient} with the specified API key.
	 * 
	 * @param apiKey the API key for accessing the Alpha Vantage API
	 */
	public AlphaVantageClient(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Retrieves historical stock data for the given symbol from the Alpha Vantage
	 * API.
	 * <p>
	 * The data is fetched using the "TIME_SERIES_DAILY" function and includes the
	 * closing price for each day.
	 * </p>
	 * 
	 * @param symbol the stock symbol (e.g., "MSFT" for Microsoft)
	 * @return a {@code Map} where the key is the date and the value is the closing
	 *         price
	 * @throws Exception if an error occurs while making the API request or parsing
	 *                   the response
	 */
	public Map<String, Double> getHistoricalData(String symbol) throws Exception {
		String function = "TIME_SERIES_DAILY";
		String url = BASE_URL + "function=" + function + "&symbol=" + symbol + "&apikey=" + apiKey;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String body = response.body();
		boolean limit_exceeded = false;
		Map<String, Double> historicalData = new TreeMap<>();
		if (body.contains("API rate limit"))
			limit_exceeded = true;
		if (limit_exceeded == false) {
			JsonObject jsonResponse = JsonParser.parseString(body).getAsJsonObject();

			JsonObject timeSeries = jsonResponse.getAsJsonObject("Time Series (Daily)");

			for (Map.Entry<String, JsonElement> entry : timeSeries.entrySet()) {
				String date = entry.getKey();
				JsonObject dayData = entry.getValue().getAsJsonObject();
				double closingPrice = dayData.get("4. close").getAsDouble();
				historicalData.put(date, closingPrice);
			}
		}
		return historicalData;
	}

	/**
	 * Writes the historical stock data to a CSV file.
	 * <p>
	 * The file will contain the stock name, date, and closing price for each day.
	 * </p>
	 * 
	 * @param stockSymbol the stock symbol (e.g., "MSFT" for Microsoft)
	 * @param data        a {@code Map} containing the date as the key and the
	 *                    closing price as the value
	 * @param filename    the name of the file to which the data will be written
	 */
	public void writeDataToFile(String stockSymbol, Map<String, Double> data, String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			writer.write("Stock Name,Date,Close Price\n");
			for (Map.Entry<String, Double> entry : data.entrySet()) {
				System.out.println(stockSymbol + " | Date: " + entry.getKey() + " | Close Price: " + entry.getValue());
				writer.write(stockSymbol + "," + entry.getKey() + "," + entry.getValue() + "\n");
			}
			System.out.println("Data written to " + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method to run the {@code AlphaVantageClient}.
	 * <p>
	 * This method reads the API key from the configuration file, retrieves
	 * historical data for the Microsoft stock ("MSFT"), and writes the data to a
	 * CSV file.
	 * </p>
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		try {
			ConfigReader config = new ConfigReader("config.ini");
			AlphaVantageClient client = new AlphaVantageClient(config.getApiKey());
			String stockSymbol = "MSFT";
			Map<String, Double> data = client.getHistoricalData(stockSymbol);

			client.writeDataToFile(stockSymbol, data, "stock_data.csv");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
