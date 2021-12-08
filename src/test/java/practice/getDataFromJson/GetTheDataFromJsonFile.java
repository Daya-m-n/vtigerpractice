package practice.getDataFromJson;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class GetTheDataFromJsonFile
{
	@Test
	public void getData() throws Throwable
	{
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader("./data/credentials.json");
		Object object = parser.parse(reader);
		JSONObject jsonobj = (JSONObject) object;
		String browserName = jsonobj.get("browser").toString();
		String url = jsonobj.get("url").toString();
		String username = jsonobj.get("username").toString();
		String password = jsonobj.get("password").toString();

		System.out.println(browserName);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
}
