package RestAssured.RestAssuredProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;




public class WaysToCreatePostRequest {
   String id ;
	//JsonObject
	@Test(priority =1)
	void postReqUsingJSONLibrary() {
	
		JSONObject data = new JSONObject();
		data.put("name", "Ravi");
		data.put("location", "United States");
		data.put("phone", "3828931");
		String coursearray[]= {	"selenium"};
		data.put("course", coursearray);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Ravi"))
		.body("location", equalTo("United States"))
		.log().all();
		
	}
	
	@Test(priority=2)
	void pojoPostRequest() {
		POJO_postRequest data = new POJO_postRequest();
        
		data.setName("Gayatri");
		data.setLocation("India");
		data.setPhone("3635753");
		String coursearr[] = {"spring","fullstack"};
		data.setCourse(coursearr);
      
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Gayatri"))
		.body("location", equalTo("India"))
		.log().all();
	}
	
	//externalfile
	@Test(priority =3)
	void postReqUsingExternalFile() throws FileNotFoundException {
		
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener JT = new JSONTokener(fr);
		JSONObject data = new JSONObject(JT);
		
		id = given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
	    .jsonPath().getString("id");
		
		
	}
	
	@Test(priority = 4)
	void updateData() {
		JSONObject data = new JSONObject();
		data.put("name", "Rohit");
		data.put("phone", "387923325");
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.put("http://localhost:3000/students/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}
	
}
