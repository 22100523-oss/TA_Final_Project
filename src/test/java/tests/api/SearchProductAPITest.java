package tests.api;

import base.BaseAPITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SearchProductAPITest extends BaseAPITest {

    @Test(description = "Search Product API")
    public void searchProductAPI() {
        Response response = given()
                .spec(requestSpec)
                .formParam("search_product", "Blue Top")
                .when()
                .post("/api/searchProduct")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200);
        Assert.assertTrue(response.jsonPath().getList("products").size() > 0);

        System.out.println("Products Found: " + response.jsonPath().getList("products").size());
    }
}