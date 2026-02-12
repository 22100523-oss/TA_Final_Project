package tests.api;

import base.BaseAPITest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("API Testing")
@Feature("Cart Management")
public class RemoveFromCartApiTest extends BaseAPITest {

    @Test(description = "API: Remove product from cart")
    @Story("Remove from Cart")
    @Severity(SeverityLevel.NORMAL)
    public void removeProductFromCart() {
        Response response = given()
                .spec(requestSpec)
                .formParam("product_id", "1")
                .when()
                .post("/api/removeFromCart")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getString("message").contains("removed from cart"));

        System.out.println("Remove From Cart Response: " + response.jsonPath().getString("message"));
    }
}