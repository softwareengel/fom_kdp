package de.fom.kdp.project.lib.nominatimapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * This class demonstrates how to search for railway stations in a specific city
 * using the Nominatim API from OpenStreetMap. The search is conducted using a
 * keyword that combines the term "railway station" with the city name "Dortmund".
 * The results are then parsed and printed, displaying the name, latitude, and 
 * longitude of each station found.
 */

public class RailwayStationSearchInCity {
    /**
     * Main method to execute the search query and process the response.
     * 
     * The method connects to the Nominatim API with a specified search keyword
     * (in this case, "railway station Dortmund"), sends a GET request, and processes
     * the returned JSON data to extract and print the names, latitudes, and longitudes
     * of the railway stations found in Dortmund.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Define the API endpoint with the search keyword and city
            String keyword = "railway station Dortmund";
            
            String url = "https://nominatim.openstreetmap.org/search?q=" + 
                         java.net.URLEncoder.encode(keyword, "UTF-8") + "&format=json";
            
            // Create a URL object
            URL obj = new URL(url);
            
            // Open a connection
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            // Set the request method
            con.setRequestMethod("GET");
            
            // Get the response code
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            
            // If response is OK (200), read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Use Gson to parse the JSON response
                Gson gson = new Gson();
                JsonArray jsonArray = JsonParser.parseString(response.toString()).getAsJsonArray();
                
                // Loop through the results and print lat, lon, and name
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject station = jsonArray.get(i).getAsJsonObject();
                    String lat = station.get("lat").getAsString();
                    String lon = station.get("lon").getAsString();
                    String name = station.get("display_name").getAsString();
                    
                    System.out.println("Name: " + name);
                    System.out.println("Latitude: " + lat);
                    System.out.println("Longitude: " + lon);
                    System.out.println("-------------");
                }
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
