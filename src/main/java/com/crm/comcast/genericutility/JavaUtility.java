package com.crm.comcast.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic libraries
 * 
 * @author Dayananda M N
 *
 */
public class JavaUtility
{
	/**
	 * It is used to generate the integer Random number with in the boundary of 0 to
	 * 15000.
	 * 
	 * @return intData
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomNum = random.nextInt(15000);
		return randomNum;
	}

	/**
	 * This method is used to get the current system date and time.
	 * 
	 * @return systemDate
	 */
	public String getSystemDate()
	{
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}

	/**
	 * This method is used to get the current system date with YYYY-MM-DD format
	 * 
	 * @return YYYY-MM-DD
	 */
	@SuppressWarnings("deprecation")
	public String getSystemDateFormat()
	{
		Date date = new Date();
		String[] localDateANdTime = date.toString().split(" ");
		String DD = localDateANdTime[2];
		String YYYY = localDateANdTime[5];
		int MM = date.getMonth() + 1;
		String finalDateFormat = YYYY + "-" + MM + "-" + DD;
		return finalDateFormat;

	}

	public String getTimeDateFormat()
	{
		Date date = new Date();
		String localDateANdTime = date.toString().replace(":", "_").replace(" ", "_");
		return localDateANdTime;

	}

}
