package Serialization_and_Deserialization_using_JSON;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import javax.management.InvalidApplicationException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentsAPI_With_SerialiandDeseriali {

	
	@Test(priority = 1, description = "creating new user")
	public void testCreateNewUser() {
		ArrayList<String> courseList  = new ArrayList<String>();
		courseList.add("java");
		courseList.add("selenium");
		
		Student stu = new Student();
		stu.setId(101);
		stu.setFirstName("Devin");
		stu.setLastName("Ai");
		stu.setEmail("devinai@congnitionlabs.com");
		stu.setProgram("Artificial Intelegence");
		stu.setCourses(courseList);

		
		given().
			contentType("application/json").
			body(stu).
		when().
			post("http://locolhost:3030/students/users").
		then().
			statusCode(201).
			assertThat().
			body("msg", equalTo("Student Added"));
	}
	
	
	
	
	@Test(priority=2, description="deserializing")
	public void getStudentRecord() {
		Student stu = get("http://localhost:3030/student/user/101").as(Student.class);
		System.out.println(stu.toString());
		Assert.assertEquals(stu.getId(), 101);
	}
}
