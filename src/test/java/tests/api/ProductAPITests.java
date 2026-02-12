package tests.api;

import base.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("API Testing")
@Feature("Product API")
public class ProductAPITests extends BaseTest {

    @Test(priority = 1, description = "API 1: Get All Products List")
    @Story("Product Management")
    @Description("Test Case: GET to /api/productsList - Verify all products are returned")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllProductsList() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/api/productsList")  // Changed from POST to GET
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200, "Response code should be 200");
        Assert.assertNotNull(response.jsonPath().getList("products"), "Products list should not be null");
        Assert.assertTrue(response.jsonPath().getList("products").size() > 0, "Products list should contain items");

        System.out.println("✓ Total Products: " + response.jsonPath().getList("products").size());
    }

    @Test(priority = 2, description = "API 2: POST To All Products List")
    @Story("Product Management")
    @Description("Test Case: POST to /api/productsList - Should return method not supported")
    @Severity(SeverityLevel.NORMAL)
    public void postToProductsList() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .post("/api/productsList")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 405, "Response code should be 405");
        Assert.assertTrue(response.jsonPath().getString("message")
                .contains("This request method is not supported"));

        System.out.println("✓ Method Validation: " + response.jsonPath().getString("message"));
    }

    @Test(priority = 3, description = "API 3: Get All Brands List")
    @Story("Brand Management")
    @Description("Test Case: GET to /api/brandsList - Verify all brands are returned")
    @Severity(SeverityLevel.NORMAL)
    public void getAllBrandsList() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/api/brandsList")  // Changed from POST to GET
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200, "Response code should be 200");
        Assert.assertNotNull(response.jsonPath().getList("brands"), "Brands list should not be null");
        Assert.assertTrue(response.jsonPath().getList("brands").size() > 0, "Brands list should contain items");

        System.out.println("✓ Total Brands: " + response.jsonPath().getList("brands").size());
    }

    @Test(priority = 4, description = "API 4: PUT To All Brands List")
    @Story("Brand Management")
    @Description("Test Case: PUT to /api/brandsList - Should return method not supported")
    @Severity(SeverityLevel.NORMAL)
    public void putToBrandsList() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .put("/api/brandsList")
                .then()
                .extract().response();

        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 405);
        Assert.assertTrue(response.jsonPath().getString("message")
                .contains("This request method is not supported"));

        System.out.println("✓ Method Validation: " + response.jsonPath().getString("message"));
    }

    @Test(priority = 5, description = "API 5: Search Product")
    @Story("Product Search")
    @Description("Test Case: POST to /api/searchProduct with search parameter")
    @Severity(SeverityLevel.CRITICAL)
    public void searchProduct() {
        String searchQuery = "top";

        Response response = given()
                .spec(requestSpec)
                .formParam("search_product", searchQuery)
                .when()
                .post("/api/searchProduct")
                .then()
                .extract().response();

        Allure.addAttachment("Search Query", "search_product=" + searchQuery);
        Allure.addAttachment("API Response", "application/json", response.asPrettyString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200);
        Assert.assertNotNull(response.jsonPath().getList("products"), "Products list should not be null");

        System.out.println("✓ Search Results for '" + searchQuery + "': " +
                response.jsonPath().getList("products").size() + " products found");
    }
}