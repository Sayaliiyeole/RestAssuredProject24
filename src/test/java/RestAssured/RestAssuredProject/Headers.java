package RestAssured.RestAssuredProject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;
import RestAssured.RestAssuredProject.Headers;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Headers {

	@Test
	public void getHeaders() {

		when()

				.get("http://localhost:3000/students")

				.then()
				.header("Content-Type", "application/json")
				
				.header("X-Powered-By", "tinyhttp");

	}
	
	@Test
	public void allHeaders() {
   
	Response res = 	given()
		
		.when()

				.get("http://localhost:3000/students");
	             io.restassured.http.Headers header = res.getHeaders();
	             for(Header h: header) {
	            	 System.out.println(h);
	             }
	

				
	}
}
