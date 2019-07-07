package com.wonderland.com.wonderland;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wonderland.request.CreatePupilRequest;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;
public class ApplicationTests {

	// @Test
	 public void getAll() {
		 given().when().get("http://localhost:8080/api/pupil").then().log().body().statusCode(200);
	 }
	 
	 @Test
		 public void getById() {
			 given().when().get("http://localhost:8080/api/pupil/1").then().log().body().statusCode(200);
		 }
	 
//	 @Test
		public void create() {

		 	CreatePupilRequest request = new CreatePupilRequest();
		 	request.setAge(13);
		 	request.setName("First");
		 	request.setSurname("Guy");
			given()
			.contentType("application/json")
			.body(request)
			.when().post("http://localhost:8080/api/pupil").then().log().body()
			.statusCode(200);
		}

	 
//	 @Test
		public void createSecondGuy() {

		 	CreatePupilRequest request = new CreatePupilRequest();
		 	request.setAge(15);
		 	request.setName("Second");
		 	request.setSurname("Guy");
			given()
			.contentType("application/json")
			.body(request)
			.when().post("http://localhost:8080/api/pupil").then().log().body()
			.statusCode(200);
		}

}
