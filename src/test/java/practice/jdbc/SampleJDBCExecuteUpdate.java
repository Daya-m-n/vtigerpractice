package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate
{
	@Test
	public void sampleJDBCExecuteUpdate() throws SQLException
	{
		// Step-1: Register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// Step-2: Get connection with database provide database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");

		// Step-3: Issue create statement
		Statement stat = con.createStatement();

		// Step-4: Execute a update provide table name
		int update = stat.executeUpdate("insert into studentinfo values('Madanna',16,'delhi')");

		if (update == 1)
		{
			System.out.println("Data inserted");
		} else
		{
			System.out.println("Data not generated");
		}

		// Step-5: Close the database
		con.close();

	}
}
