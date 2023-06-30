package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.TestNG_Common_Utility_Method;
import Common_API_Methods.TestNG_Put_API_Methods;
import Request_Respository.TestNG_Put_Request_Respository;
import io.restassured.path.json.JsonPath;

public class TestNG_Put_TC1 {
	@Test
	public static void Extractor() throws IOException
	{
		
		String baseURI = TestNG_Put_Request_Respository.BaseURI();
		String requestBody = TestNG_Put_Request_Respository.Put_Req_TC1();
		String resource = TestNG_Put_Request_Respository.Put_Resource();

		int statusCode = TestNG_Put_API_Methods.ResponseStatusCode(baseURI,resource,requestBody);
		System.out.println(statusCode);
		
		JsonPath JPut_Req = new JsonPath(TestNG_Put_Request_Respository.Put_Req_TC1());
		String put_req_name = JPut_Req.getString("name");
		String put_req_job = JPut_Req.getString("job");
		
		String ResponseBody = TestNG_Put_API_Methods.ResponseBody(baseURI, resource, requestBody);
		System.out.println(ResponseBody);
				
		TestNG_Common_Utility_Method.EvidenceCreator("Put_TC1",TestNG_Put_Request_Respository.Put_Req_TC1(),ResponseBody ,statusCode);
		
		JsonPath JPut = new JsonPath(ResponseBody);
		String put_res_name = JPut.getString("name");
		String put_res_job = JPut.getString("job");
		
		Assert.assertEquals(put_res_name, put_req_name);
		Assert.assertEquals(put_res_job, put_req_job);
		
}

}

