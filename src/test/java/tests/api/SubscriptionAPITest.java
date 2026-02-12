package tests.api;

import base.BaseAPITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SubscriptionAPITest extends BaseAPITest {

    @Test(description = "Subscription API")
    public void subscriptionAPI() {
        Response response = given()
                .spec(requestSpec)
                .formParam("email", "testuser@example.com")
                .when()
                .post("/api/subscribe")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Subscription API Response: " + response.asString());
    }
}