package com.ijmeet.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	
	/**
	 * This method will open ObjectRepository.properties and will return value associated with key
	 * @param locatorName
	 * @return value in form of{@code String}
	 */
	public static String[] getLocator(String key) {
		String[] values = null;
		String path=System.getProperty("user.dir");
		//System.out.println(path);
		try {
			
			FileInputStream fis = new FileInputStream(path+"/src/test/resources/ObjectRepository.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String part = prop.getProperty(key);
			values = part.split("##");
			//System.out.println("Locator Type: " + values[0]);
			//System.out.println("Locator Value: " + values[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		return values;

	}
	
	public static String getProperty(String key) {
		String value = null;
		String path = System.getProperty("user.dir");
		try {
			FileInputStream file = new FileInputStream(path +"/src/test/resources/ObjectRepository.properties");
			Properties prop = new Properties();
			prop.load(file);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}

