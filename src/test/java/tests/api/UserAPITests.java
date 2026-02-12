package tests.api;

import base.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("API Testing")
@Feature("User API")
public class UserAPITests extends BaseTest {

    @Test(priority = 1, description = "API 11: POST To Create/Register User Account")
    @Story("User Registration")
    @Description("Test Case: POST to /api/createAccount - Create new user account")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserAccount() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "testuser" + timestamp + "@example.com";

        Response response = given()
                .spec(requestSpec)
                .formParam("name", "Test User")
                .formParam("email", email)
                .formParam("password", "Test@123")
                .formParam("title", "Mr")
                .formParam("birth_date", "15")
                .formParam("birth_month", "5")
                .formParam("birth_year", "1990")
                .formParam("firstname", "Test")
                .formParam("lastname", "User")
                .formParam("company", "TestCompany")
                .formParam("address1", "123 Test Street")
                .formParam("address2", "Apt 4B")
                .formParam("country", "United States")
                .formParam("zipcode", "12345")
                .formParam("state", "California")
                .formParam("city", "Los Angeles")
                .formParam("mobile_number", "1234567890")
                .when()
                .post("/api/createAccount")
                .then()
                .extract().response();

        Allure.addAttachment("Request Email", email);
        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 201,
                "Response code should be 201 for account created");
        Assert.assertTrue(response.jsonPath().getString("message").contains("User created!"),
                "Message should confirm user creation");

        System.out.println("✓ Account Created: " + email);
        System.out.println("✓ Response: " + response.jsonPath().getString("message"));
    }

    @Test(priority = 2, description = "API 9: DELETE METHOD To Verify Login")
    @Story("User Authentication")
    @Description("Test Case: DELETE to /api/verifyLogin - Should return method not supported")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLoginWithDeleteMethod() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .delete("/api/verifyLogin")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 405,
                "Response code should be 405 for invalid method");
        Assert.assertTrue(response.jsonPath().getString("message")
                        .contains("This request method is not supported"),
                "Message should indicate method not supported");

        System.out.println("✓ Method Validation: " + response.jsonPath().getString("message"));
    }

    @Test(priority = 3, description = "API 10: POST To Verify Login without email parameter")
    @Story("User Authentication")
    @Description("Test Case: POST to /api/verifyLogin without email parameter")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLoginWithoutEmail() {
        Response response = given()
                .spec(requestSpec)
                .formParam("password", "Test@123")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract().response();

        Allure.addAttachment("Request Parameters", "password=Test@123");
        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 400,
                "Response code should be 400 for missing email");
        Assert.assertTrue(response.jsonPath().getString("message")
                .contains("Bad request"), "Message should indicate bad request");

        System.out.println("✓ Validation: " + response.jsonPath().getString("message"));
    }

    @Test(priority = 4, description = "API 6: POST To Search Product without search_product parameter")
    @Story("Product Search")
    @Description("Test Case: POST to /api/searchProduct without search_product parameter")
    @Severity(SeverityLevel.NORMAL)
    public void searchProductWithoutParameter() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .post("/api/searchProduct")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 400,
                "Response code should be 400 for missing parameter");
        Assert.assertTrue(response.jsonPath().getString("message")
                .contains("Bad request"), "Message should indicate bad request");

        System.out.println("✓ Validation passed: " + response.jsonPath().getString("message"));
    }

    @Test(priority = 5, description = "API 13: POST To Verify Login with valid details")
    @Story("User Authentication")
    @Description("Test Case: POST to /api/verifyLogin with invalid details for negative test")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginWithInvalidDetails() {
        Response response = given()
                .spec(requestSpec)
                .formParam("email", "invalid@test.com")
                .formParam("password", "wrongpassword")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract().response();

        Allure.addAttachment("Request Parameters", "email=invalid@test.com&password=wrongpassword");
        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 404,
                "Response code should be 404 for user not found");
        Assert.assertTrue(response.jsonPath().getString("message")
                .contains("User not found!"), "Message should indicate user not found");

        System.out.println("✓ Invalid Login: " + response.jsonPath().getString("message"));
    }
}