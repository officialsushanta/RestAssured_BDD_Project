package Without_Serializing_and_Deserializing;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class StudentsAPI_Example {

	
	@Test(priority =1, description = "creating new user")
	public void createNewUser() {
		
		HashMap map = new HashMap();
		map.put("id", "101");
		map.put("firstName", "Mark");
		map.put("lastName", "Tyson");
		map.put("email", "marktyson@gmail.com");
		map.put("program", "manager");
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		map.put("courses", coursesList);
		
		given().
			contentType(ContentType.JSON).
			body(map).
		when().
			post("http://localhost/studentsapi/users").
		then().
			statusCode(201).assertThat().
			body("msg", equalTo("Student added"));
		
	}
	
	
	@Test(priority=2, description="getting newly created user details")
	public void getUserDetails() {
		given().
		when().
			get("http://localhost:3030/studentsapi/users/101").
		then().
			statusCode(200).
			assertThat().body("id", equalTo(101)).
			log().all();
	}
}
