package Serialization_and_Deserialization_using_XML;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class VideoGame_API_XML_Format {

	
	@Test(priority=1, description = "create New User")
	public void testVideoGameXMLFormat_CreateUser() {
		VideoGame myVideoGame = new VideoGame();
		myVideoGame.setId(11); //as 10 games were already created so from 11 new game will be regestered
		myVideoGame.setName("Clash of Clans");
		myVideoGame.setReleaseDate("26-03-2024");
		myVideoGame.setReviewScore(4);
		myVideoGame.setCategory("Online Game");
		myVideoGame.setRating("Got overall 4.5 star ratings");
		
		given().
			contentType("application/xml").
			body(myVideoGame).
		when().
			post("http://localhost:8080/app/videogames").//url got from gradle
		then().
			log().all().
			body(equalTo("{\"status\":\"Record Added Successfully\"}"));
	}
	
	
	@Test(priority=2, description= "deserializing and converting xml format to string format")
	public void testVideoGameDeserialization_XMLFormat() {
		VideoGame myVideoGame = get("http://localhost:8080/app/videogames/11").as(VideoGame.class);
		System.out.println(myVideoGame.toString());
	}
}
