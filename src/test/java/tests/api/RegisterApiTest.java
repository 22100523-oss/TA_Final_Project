package tests.api;

import base.BaseAPITest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("API Testing")
@Feature("User Registration")
public class RegisterApiTest extends BaseAPITest {

    @Test(description = "API: Create new user account")
    @Story("User Registration")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserAccount() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "user" + timestamp + "@example.com";

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

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 201);
        Assert.assertTrue(response.jsonPath().getString("message").contains("User created"));

        System.out.println("User Registered: " + email);
    }
}