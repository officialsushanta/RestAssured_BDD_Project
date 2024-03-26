package BDD_Project;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_POST_Request {

	public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void postData() {
	
	map.put("First Name", RestUtils.getFirstName());
	map.put("Last Name", RestUtils.getLastName());
	map.put("User Name", RestUtils.getUserName());
	map.put("Password", RestUtils.getPassword());
	map.put("Email id", RestUtils.getEmail());
	
	RestAssured.baseURI = "http://restapi.demoqa.com/customer";
	RestAssured.basePath = "/register";
	}
	
	@Test
	public void tetsPost() {
		given().
			contentType("application/json").
			body(map).
		when().
			post().
		then().
			statusCode(201).
			body("Success Code", equalTo("Operation-Success")).
			body("Message", equalTo("Operation Completed Successfully"));
	}
}
