package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {

    private static EnvConfig instance;
    private Properties properties;
    private static final String PROPERTIES_FILE = configFilePath(); // Path to your properties file

    public static String configFilePath() {
        String env = System.getProperty("env", "qa");
        String pathString = System.getProperty("user.dir");
        String parentPathString = "";
        if (env.equalsIgnoreCase("qa")) {
            parentPathString = pathString + "\\src\\main\\resources\\qaConfig.properties";
        } else if (env.equalsIgnoreCase("dev")) {
            parentPathString = pathString + "\\src\\main\\resources\\devConfig.properties";
        }
        return parentPathString;
    }

    private EnvConfig() {
        properties = new Properties();
        loadProperties();
    }

    public static synchronized EnvConfig getInstance() {
        if (instance == null) {
            instance = new EnvConfig();
        }
        return instance;
    }

    private void loadProperties() {
        try (InputStream input = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}



