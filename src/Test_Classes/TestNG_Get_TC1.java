package Test_Classes;
import java.io.IOException;

import org.testng.annotations.Test;

import Common_API_Methods.TestNG_Common_Utility_Method;
import Common_API_Methods.TestNG_Get_API_Methods;
import Request_Respository.TestNG_Get_Request_Respository;

public class TestNG_Get_TC1 {
	@Test
	public static void Extractor() throws IOException
	{
		String baseURI = TestNG_Get_Request_Respository.BaseURI();
		String resource = TestNG_Get_Request_Respository.Get_Resource();
		
		int statusCode = TestNG_Get_API_Methods.ResponseStatusCode(baseURI,resource);
		System.out.println(statusCode);
		
		String ResponseBody = TestNG_Get_API_Methods.ResponseBody(baseURI, resource);
		System.out.println(ResponseBody);
		TestNG_Common_Utility_Method.EvidenceCreator("Get_TC1",TestNG_Get_Request_Respository.Get_Resource(),ResponseBody ,statusCode);
	}

}
