package de.fom.kdp.project.lib.osmapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * This class demonstrates how to connect to the OpenStreetMap API,
 * send a GET request to retrieve map data within a specific bounding box,
 * and print the XML response.
 */
public class OpenStreetMapExample {
    /**
     * Main method to execute the API request and process the response.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Define the API endpoint
            String url = "https://api.openstreetmap.org/api/0.6/map?bbox=11.54,48.14,11.543,48.145";
            
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
                
                // Print the raw XML response from OpenStreetMap
                System.out.println(response.toString());
                
                // Here, you can process the XML or convert it to a desired format
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
