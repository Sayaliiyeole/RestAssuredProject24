package RestAssured.RestAssuredProject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {

	int id ;

	@Test(priority= 1)
	void getUser() {

				when()

				.get("https://reqres.in/api/users/2")

				.then().statusCode(200).log().all();

	}
	
	@Test(priority= 2)
	void addUser() {
		
		HashMap data = new HashMap();
				data.put("name", "sayali");
				data.put("job", "Automation Tester");
				
		id = given()
		.contentType("application/json")
		.body(data)
		
		.when()
		 .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");
		//.then()
		 //.statusCode(201)
		 //.log().all();
		System.out.println(id);
	}
	
	@Test(priority=3)
	void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "sayali");
		data.put("job", "QA");
		
		given()
	   .contentType("application/json")
	    .body(data)
	    
		.when()
		 .put("https://reqres.in/api/users/"+id) 
		
         .then()
         .statusCode(200)
         .log().all();
         
		
	}
	
	@Test(priority = 4)
	void deleteUser() {
		
		when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204);
		
	}

}