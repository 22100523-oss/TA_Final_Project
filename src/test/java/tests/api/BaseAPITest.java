package tests.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {
    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setupAPI() {
        RestAssured.baseURI = "https://automationexercise.com";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com")
                .setContentType("application/x-www-form-urlencoded")
                .build();
    }
}