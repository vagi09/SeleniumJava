package com.config.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	private static final String PROPERTY_FILE = "src/main/java/com/config/properties/config.properties";
	private Properties properties;

	public ConfigurationReader() {
		loadProperties();
	}

	private void loadProperties() {
		properties = new Properties();
		try (FileInputStream fis = new FileInputStream(PROPERTY_FILE)) {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPageUrl() {
		return properties.getProperty("page.url");
	}

	public String getUserName() {
		return properties.getProperty("user.name");
	}

	public String getPassword() {
		return properties.getProperty("user.password");
	}
}
