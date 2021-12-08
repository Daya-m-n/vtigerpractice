package com.crm.SDET25.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class contains generic methods for reading data from property file.
 * 
 * @author Dayananda M N
 *
 */
public class FileUtility
{
	/**
	 * This method is used to read the data from property file
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.PROPERTY_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

	/**
	 * This method will return value from the json file based on the key passed
	 * 
	 * @param jasonKeyToPass
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromJsonFile(String jasonKeyToPass) throws Throwable
	{
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(IpathConstants.JSON_PATH);
		Object object = parser.parse(reader);
		JSONObject jsonObj = (JSONObject) object;
		return jsonObj.get(jasonKeyToPass).toString();
	}
}
