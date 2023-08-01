package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    static ValidatableResponse response;

    @Test
    public void verifyUserCreatedSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Sarvat");
        userPojo.setEmail(getRandomString(6)+getRandomValue()+"@googly.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");
        Response response = given()

                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);

    }
}
