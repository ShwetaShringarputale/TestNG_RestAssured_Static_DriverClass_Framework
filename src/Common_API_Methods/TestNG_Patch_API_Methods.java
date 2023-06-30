package Common_API_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class TestNG_Patch_API_Methods {
	public static int ResponseStatusCode(String BaseURI, String Resource, String requestBody)
	{
		RestAssured.baseURI=BaseURI;
		
		int statusCode=given().header("Content-Type","application/json").
		        body(requestBody).when().patch(Resource).
		        then().extract().statusCode();
		return statusCode;
	}
	public static String ResponseBody(String BaseURI, String Resource, String requestBody)
	{
		RestAssured.baseURI=BaseURI;
		
		String ResponseBody=given().header("Content-Type","application/json").
		        body(requestBody).when().patch(Resource).
		        then().extract().response().asPrettyString();
		return ResponseBody;
	}
}
