package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentUtils {
    private static Properties properties;

    static {
        properties = new Properties();
        String envConfigFile = System.getProperty("env.config", "default.properties");

        try (InputStream input = EnvironmentUtils.class.getClassLoader().getResourceAsStream(envConfigFile)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getEnvName() {
        return properties.getProperty("env.name");
    }

    public static String getEnvUrl() {
        return properties.getProperty("env.url");
    }

}
