package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class PostsAssertionTest extends TestBase {

    static ValidatableResponse response;

    public PostsAssertionTest() {
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);

    }

    @Test
    public void test001() {
        response.body("size", equalTo(25));
    }

    @Test
    public void test002() {
        response.body("find{it.id = 57253}.title", equalTo("Aggero coerceo acceptus vereor molestias."));
    }

    @Test
    public void test003() {
        response.body("[8].user_id", equalTo(4040726));
    }

    @Test
    public void test004() {
        response.body("id", hasItems(56978, 56977, 56979));
    }
    @Test
    public void test005() {
        response.body("find{it.user_id == 4040734}.body", equalTo("Aperio uredo vesper. Supplanto suasoria adiuvo. Vulgus stella demulceo. Consequatur chirographum vomica. Eos consequatur cilicium. Ipsa cedo vallum. Tenax repellat aestivus. Sint accipio viscus. Vado aggero stillicidium. Coepi claustrum conforto. Vetus curtus accusantium. Capto ipsam pax. Aperio consuasor vero. Aut tredecim terror."));
    }


}
