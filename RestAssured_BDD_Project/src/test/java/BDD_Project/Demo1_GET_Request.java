package BDD_Project;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Demo1_GET_Request {
	
	@Test	
	public void getWeatherDetails() {
	given().
	when().
		get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").
	then().
		statusCode(200).
		statusLine("HTTP/1.1 200 OK").
		assertThat().body("city", equalTo("Hydereabad")).
		header("Content-Type", "application/json");	
	}

}
