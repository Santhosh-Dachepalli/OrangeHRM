package com.orangehrm.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to load config.properties file.");
        }
    }

    // ✅ Static method so you can call ConfigReader.get("url")
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
