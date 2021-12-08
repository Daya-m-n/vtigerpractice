package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery
{
	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
		// Step-1: Register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// Step-2: Get connection with database provide database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");

		// Step-3: Issue create statement
		Statement stat = con.createStatement();

		// Step-4: Execute a query provide table name
		ResultSet result = stat.executeQuery("select * from studentinfo");
		while (result.next())
		{
			System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
		}

		// Step-5: Close the database
		con.close();

	}
}
