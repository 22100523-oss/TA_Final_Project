package tests.api;

import base.BaseAPITest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("API Testing")
@Feature("User Authentication")
public class LogoutApiTest extends BaseAPITest {

    @Test(description = "API: Logout user")
    @Story("User Logout")
    @Severity(SeverityLevel.NORMAL)
    public void logoutUser() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/api/logout")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getString("message").contains("successfully logged out"));

        System.out.println("Logout Response: " + response.jsonPath().getString("message"));
    }
}