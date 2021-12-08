package practice.getDataFromXmlFile;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class GetTheDataFromXmlFile
{
	@Test
	public void getData(XmlTest xml)
	{
		// XmlTest xml=new XmlTest();
		String browserName = xml.getParameter("browser");
		System.out.println(browserName);

		String username = xml.getParameter("username");
		System.out.println(username);

		String password = xml.getParameter("password");
		System.out.println(password);

	}
}
