package RestAssured.RestAssuredProject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Path_QueryParam {
   
	@Test
	public void parameters() {
		
		given()
		
		.pathParam("user_path", "students")
		.queryParam("page", 1)
		.queryParam("id", 2)
		
		.when()
		 .get("http://localhost:3000/{user_path}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
