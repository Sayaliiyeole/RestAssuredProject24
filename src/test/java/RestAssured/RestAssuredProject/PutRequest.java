package RestAssured.RestAssuredProject;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PutRequest {

	@Test
	public void updateData() {
		
	HashMap	map = new HashMap();
	map.put("name", "john");
	String[] coursearray = {"json","html"};
	map.put("course", coursearray);
	
		
		given()
		.contentType("application/json")
		.body(map)
		
		.when()
		.put("http://localhost:3000/students/237e")
	  .then()
	  .statusCode(200)
	   .log().all();
	  
	}
	
}
