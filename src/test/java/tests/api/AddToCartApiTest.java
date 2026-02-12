package tests.api;

import base.BaseAPITest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("API Testing")
@Feature("Cart Management")
public class AddToCartApiTest extends BaseAPITest {

    @Test(description = "API: Add product to cart")
    @Story("Add to Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void addProductToCart() {
        Response response = given()
                .spec(requestSpec)
                .formParam("product_id", "1")
                .formParam("quantity", "1")
                .when()
                .post("/api/addToCart")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getString("message").contains("added to cart"));

        System.out.println("Add To Cart Response: " + response.jsonPath().getString("message"));
    }
}