package tests.api;

import base.BaseAPITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ContactFormAPITest extends BaseAPITest {

    @Test(description = "Contact Form API")
    public void contactFormAPI() {
        Response response = given()
                .spec(requestSpec)
                .formParam("name", "Test User")
                .formParam("email", "testuser@example.com")
                .formParam("subject", "Test Subject")
                .formParam("message", "This is a test message.")
                .when()
                .post("/api/contactUs")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200);
        Assert.assertTrue(response.jsonPath().getString("message").contains("submitted successfully"));

        System.out.println("Contact Form Submitted: " + response.jsonPath().getString("message"));
    }
}