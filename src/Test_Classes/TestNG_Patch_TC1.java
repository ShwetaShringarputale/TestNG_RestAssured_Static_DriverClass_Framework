package Test_Classes;
import Request_Respository.TestNG_Patch_Request_Respository;
import io.restassured.path.json.JsonPath;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.TestNG_Common_Utility_Method;
import Common_API_Methods.TestNG_Patch_API_Methods;

public class TestNG_Patch_TC1 {
	@Test
	public static void Extractor() throws IOException
	{
		String baseURI = TestNG_Patch_Request_Respository.BaseURI();
		String requestBody = TestNG_Patch_Request_Respository.Patch_Req_TC1();
		String resource = TestNG_Patch_Request_Respository.Patch_Resource();
		
		JsonPath JPatch_Req = new JsonPath(TestNG_Patch_Request_Respository.Patch_Req_TC1());
		String patch_req_name =  JPatch_Req.getString("name");
		String patch_req_job = JPatch_Req.getString("job");
		
		int statusCode = TestNG_Patch_API_Methods.ResponseStatusCode(baseURI,resource,requestBody);
		System.out.println(statusCode);
		
		String ResponseBody = TestNG_Patch_API_Methods.ResponseBody(baseURI, resource, requestBody);
		System.out.println(ResponseBody);
		TestNG_Common_Utility_Method.EvidenceCreator("Patch_TC1",TestNG_Patch_Request_Respository.Patch_Req_TC1(),ResponseBody ,statusCode);
		
		JsonPath JPatch = new JsonPath(ResponseBody);
		String patch_res_name = JPatch.getString("name");
		String patch_res_job = JPatch.getString("job");
		
		Assert.assertEquals(patch_res_name, patch_req_name);
		Assert.assertEquals(patch_res_job, patch_req_job);
	
	}

}
