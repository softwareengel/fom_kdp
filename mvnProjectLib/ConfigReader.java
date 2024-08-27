package de.fom.kdp.project.lib.alphavantage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader(String fileName) throws IOException {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(fileName)) {
            properties.load(input);
        }
    }

    public String getApiKey() {
        return properties.getProperty("apiKey");
    }

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
