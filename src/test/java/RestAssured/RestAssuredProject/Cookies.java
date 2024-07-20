package RestAssured.RestAssuredProject;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.response.Response;




public class Cookies {

	@Test
	public void cookies() {
		
		given()
		
		.when()
		
		.get("https://www.google.com/")
		
		.then()
		.statusCode(200)
		.cookie("AEC")
		;
		
	}
	
	@Test
	public void allCookies() {
		
	Response res =	given()
		
		.when()
		
		.get("https://www.google.com/");
	   
	         Map<String, String> cookie = res.getCookies();
	         for(Entry<String, String> s : cookie.entrySet()) {
	        	 System.out.println(s);
	         }
	}
	
	
}
