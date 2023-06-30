package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.TestNG_Common_Utility_Method;
import Common_API_Methods.TestNG_Post_API_Methods;
import Request_Respository.TestNG_Post_Request_Respository;
import io.restassured.path.json.JsonPath;
@Test
public class TestNG_Post_TC1 {
	
	public static void Extractor() throws IOException//method return nothing only execute it
	{
		int statusCode = TestNG_Post_API_Methods.ResponseStatusCode(
				TestNG_Post_Request_Respository.BaseURI(), 
				TestNG_Post_Request_Respository.Post_Resource(), 
				TestNG_Post_Request_Respository.Post_Req_TC1());
		System.out.println(statusCode);
		
		
		JsonPath JPost_Req = new JsonPath(TestNG_Post_Request_Respository.Post_Req_TC1());
		String post_req_name =  JPost_Req.getString("name");
		String post_req_job = JPost_Req.getString("job");
		
		
		String ResponseBody = TestNG_Post_API_Methods.ResponseBody(
				TestNG_Post_Request_Respository.BaseURI(), 
				TestNG_Post_Request_Respository.Post_Resource(), 
				TestNG_Post_Request_Respository.Post_Req_TC1());
		TestNG_Common_Utility_Method.EvidenceCreator("Post_TC1",TestNG_Post_Request_Respository.Post_Req_TC1(),ResponseBody ,statusCode);
		System.out.println(ResponseBody);
		
		JsonPath JPost = new JsonPath(ResponseBody);
		String post_res_name=JPost.getString("name");
        String post_res_job=JPost.getString("job");
   
      
		Assert.assertEquals(post_res_name,post_req_name);
        Assert.assertEquals(post_res_job,post_req_job);
				
	}
	
}


