package com.postman_restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.page.postman_api.postman;
import com.demo.utils.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class tc7 extends BaseTest{

    @Test(priority = 1)
    public void testGETRequest() {
        RestAssured.baseURI = "https://postman-rest-api-learner.glitch.me";

        //Step 01 - call API GET  https://postman-rest-api-learner.glitch.me//info?id=1 from postman and check response code equal 200 ,response body equal,
        //driver.get(RestAssured.baseURI);
        given().queryParam("id", "1")
            .when().get("/info")
            .then().statusCode(200)
            .and().body("message", equalTo("You made a GET request!"));


        //call API POST https://postman-rest-api-learner.glitch.me//info
        String requestBody = "{ \"name\" : \"check API\" }";

        Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .post("/info")
            .then()
                .statusCode(200)
                .body("data.name", equalTo("check API"))
                .body("message", equalTo("You made a POST request with the following data!"))
                .extract()
                .response();
        // Store the name for later use in UI test
        String extractedName = response.jsonPath().getString("data.name");
        postman click = new postman();
        click.openWebsite();
        click.inputText(extractedName); // Use the extracted name in the UI test
        click.clickSearchButton(); // Click the search button to perform the search
        //verify box search result is presented:
        Assert.assertTrue(click.getResultText(), "verify box search result is presented");
    }
    
}
