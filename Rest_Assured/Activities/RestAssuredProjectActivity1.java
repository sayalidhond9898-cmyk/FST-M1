package activities;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredProjectActivity1 {

    RequestSpecification requestSpec;

    String sshKey;
    int keyId;

    @BeforeClass
    public void setUp() {

        sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAg....";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token <GitHub access token>")
                .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                given()
                    .spec(requestSpec)
                    .body(requestBody)
                .when()
                    .post("/user/keys");

        response.then().log().all();

        // Extract key id
        keyId = response.jsonPath().getInt("id");

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(keyId > 0, "Key ID should be generated");
    }

    @Test(priority = 2)
    public void getSSHKey() {

        Response response =
                given()
                    .spec(requestSpec)
                    .pathParam("keyId", keyId)
                .when()
                    .get("/user/keys/{keyId}");

        Reporter.log("GET Response: " + response.asString(), true);

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), keyId);
    }

    @Test(priority = 3)
    public void deleteSSHKey() {

        Response response =
                given()
                    .spec(requestSpec)
                    .pathParam("keyId", keyId)
                .when()
                    .delete("/user/keys/{keyId}");

        Reporter.log("DELETE Response Status: " + response.getStatusCode(), true);

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}

