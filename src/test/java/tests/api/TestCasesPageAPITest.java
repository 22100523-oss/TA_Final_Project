package tests.api;

import base.BaseAPITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCasesPageAPITest extends BaseAPITest {

    @Test(description = "Verify Test Cases Page API")
    public void testCasesPageAPI() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/api/testCases")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Test Cases API Response: " + response.asString());
    }
}