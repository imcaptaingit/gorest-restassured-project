package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserAssertionTest extends TestBase {

    static ValidatableResponse response;

    public UserAssertionTest() {
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        response.body("size", equalTo(20));
    }
    @Test
    public void test002() {
        response.body("find{it.id ==4040731}.name", equalTo("Anand Swarup Trivedi III"));
    }

    @Test
    public void test003() {
        response.body("[2].name", equalTo("Satyen Adiga III"));
    }

    @Test
    public void test004() {
        response.body("name", hasItems("Mohini Bhat", "Dhanu Bhat", "Himadri Naik"));
    }

    @Test
    public void test005() {
        response.body("find{it.id = 2322249}.email", equalTo("iii_satyen_adiga@hammes.example"));
    }

    @Test
    public void test006() {
        response.body("find{it.name='Satyen Adiga III'}.status", equalTo("active"));
    }

    @Test
    public void test007() {
        response.body("find{it.name='Marut Mahajan'}.gender", equalTo("male"));
    }

}
