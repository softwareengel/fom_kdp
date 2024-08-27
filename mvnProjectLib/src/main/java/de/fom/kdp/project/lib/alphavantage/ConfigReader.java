package de.fom.kdp.project.lib.alphavantage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for reading configuration properties from an `.ini` file.
 * <p>
 * This class provides methods to load properties from a specified configuration
 * file and retrieve specific configuration values, such as the API key.
 * </p>
 * 
 * <p>
 * The configuration file is expected to be in a standard properties format.
 * </p>
 * 
 * <p>
 * Example of a configuration file (`config.ini`):
 * </p>
 * 
 * <pre>
 * apiKey = YOUR_API_KEY
 * </pre>
 * 
 * <p>
 * Usage:
 * </p>
 * 
 * <pre>
 * ConfigReader config = new ConfigReader("config.ini");
 * String apiKey = config.getApiKey();
 * </pre>
 * 
 * <p>
 * This class is useful for separating configuration from code, making it easier
 * to manage and secure sensitive information like API keys.
 * </p>
 * 
 * @author engels
 *
 */
public class ConfigReader {

	private Properties properties;

	/**
	 * Constructs a {@code ConfigReader} and loads the properties from the specified
	 * file.
	 * 
	 * @param fileName the name of the configuration file to load
	 * @throws IOException if an error occurs while reading the file
	 */
	public ConfigReader(String fileName) throws IOException {
		properties = new Properties();
		try (FileInputStream input = new FileInputStream(fileName)) {
			properties.load(input);
		}
	}

	/**
	 * Retrieves the API key from the loaded configuration properties.
	 * 
	 * @return the API key as a {@code String}, or {@code null} if the key is not
	 *         found
	 */
	public String getApiKey() {
		return properties.getProperty("apiKey");
	}

	/**
	 * Main method for testing the {@code ConfigReader} class.
	 * <p>
	 * This method demonstrates how to load the configuration file and retrieve the
	 * API key. It prints the API key to the console.
	 * </p>
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		try {
			ConfigReader config = new ConfigReader("config.ini");
			String apiKey = config.getApiKey();
			System.out.println("API Key: " + apiKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
