package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs/Configuation.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file");
	}

	public long getImplicitlyWait() {
		String implicitlywait = properties.getProperty("implicitlywait");
		if (implicitlywait != null) {
			try {
				return Long.parseLong(implicitlywait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse valeu: " + implicitlywait + " in to Long");
			}
		}
		return 30;
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getGoogleUrl() {
		String url = properties.getProperty("urlGoogle");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("internetexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched: " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String enviromentName = properties.getProperty("enviroment");
		if (enviromentName == null || enviromentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (enviromentName.equals("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Enviroment Type Key value in Configuration.properties is not matched: " + enviromentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public String getTestDataResourcePath() {
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if (testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}

}
