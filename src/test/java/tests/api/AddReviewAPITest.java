package tests.api;

import base.BaseAPITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddReviewAPITest extends BaseAPITest {

    @Test(description = "Add Review API")
    public void addReviewAPI() {
        Response response = given()
                .spec(requestSpec)
                .formParam("name", "Test User")
                .formParam("email", "testuser@example.com")
                .formParam("review", "Great product!")
                .formParam("product_id", 1)
                .when()
                .post("/api/addReview")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getString("message").contains("Thank you for your review"));

        System.out.println("Review API Response: " + response.jsonPath().getString("message"));
    }
}