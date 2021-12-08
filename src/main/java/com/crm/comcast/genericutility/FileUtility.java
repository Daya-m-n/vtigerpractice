package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class used to read the data from commondata.properties file.
 * @author Dayananda M N
 *
 */
public class FileUtility
{
	/**
	 * This method is used read the data from commondata.properties file based on
	 * key which you pass as an argument.
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fin = new FileInputStream("./data/CommonData.properties");
		Properties propObj = new Properties();
		propObj.load(fin);
		return propObj.getProperty(key);
	}
}
