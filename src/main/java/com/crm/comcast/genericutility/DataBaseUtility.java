package com.crm.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility
{

	public String getDataFromDataBase() throws Throwable
	{
		Connection con = null;
		try
		{
			// Step-1: Register the database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step-2: Get connection with database provide database name
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");

			// Step-3: Issue create statement
			Statement stat = con.createStatement();

			// Step-4: Execute a query provide table name
			ResultSet result = stat.executeQuery("select * fr studentinfo");
			while (result.next())
			{
				return result.getString(1);
			}
		} catch (Exception e)
		{
			//e.printStackTrace();
		} finally
		{

			// Step-5: Close the database
			con.close();
		}
		return null;

	}
}
