package com.jit.automation;

import org.testng.annotations.Test;

import com.jit.automation.model.UserData;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class APITest {

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in";
	}

	@Test
	public void getTest() {
		Response a = given().log().all().contentType(ContentType.JSON).accept(ContentType.JSON).when().get("/api/users")
				.then().statusCode(200).extract().response();

		// System.out.println(a.getBody().asPrettyString());

		UserData o = a.getBody().as(UserData.class);
		System.out.println(o.getTotal());
		System.out.println(o.getData().get(0).getFirst_name());

		/*
		 * given().log().all().contentType(ContentType.JSON).accept(ContentType.JSON).
		 * when().get("/api/users").then()
		 * .statusCode(200).assertThat().body("data[0].id", equalTo(1));
		 * Reporter.log("get Test");
		 */

	}

	@Test
	public void postTest() {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("name", "NameTest");
		body.put("job", "JobTest");
		Response a = given().log().all().contentType(ContentType.JSON).accept(ContentType.JSON).body(body)
				.post("/api/users").then().assertThat().statusCode(201).extract().response();
		int m = a.getBody().jsonPath().getInt("id");
		System.out.println("ID:" + m);
		System.out.println(a.getBody().asPrettyString());
		Reporter.log("post Test");
	}

	@Test
	public void putTest() {
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("name", "morpheus");
		body.put("job", "zion resident");
		Response a = given().log().all().accept(ContentType.JSON).body(body).when().put("/api/users/2").then()
				.statusCode(200).extract().response();
		System.out.println("Response body: " + a.getBody().prettyPrint());

	}

}
