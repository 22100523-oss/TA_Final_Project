package tests.api;

import base.BaseAPITest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("API Testing")
@Feature("User Authentication")
public class LoginApiTest extends BaseAPITest {

    @Test(description = "API: Login with valid credentials")
    @Story("User Login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithValidCredentials() {
        Response response = given()
                .spec(requestSpec)
                .formParam("email", "your_email@example.com")
                .formParam("password", "your_password")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200);
        Assert.assertTrue(response.jsonPath().getString("message").contains("success"));

        System.out.println("✓ Login API Response: " + response.jsonPath().getString("message"));
    }

    @Test(description = "API: Login with invalid credentials")
    @Story("User Login")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidCredentials() {
        Response response = given()
                .spec(requestSpec)
                .formParam("email", "invalid@test.com")
                .formParam("password", "wrongpass")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 404);
        Assert.assertTrue(response.jsonPath().getString("message").contains("User not found"));

        System.out.println("Invalid Login Response: " + response.jsonPath().getString("message"));
    }
}