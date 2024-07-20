package RestAssured.RestAssuredProject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;


public class Response_Validaation {
	
	public static HashMap<String,String> body;
	
	
	@BeforeClass
	public void body() {
	body = 	new HashMap<String,String>();
	body.put("FirstName", "Jack");
	body.put("LastName", "Bills");
	
	}
	
	@Test
	public void validation() {
	
	
	given()
	.contentType("application/JSON")
	.body(body)
	.when()
	.get("http://localhost:3000/students")
	
	
	.then()
	.statusCode(201)
	.log().all();
	
	
}
}