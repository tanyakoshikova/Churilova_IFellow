package pages;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUserSteps {
    public static void createUser(String name, String job) throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/json/test.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat market");
        Response postJson = given()
                .header("Content-type", "application/json")
                .baseUri("https://reqres.in/api")
                .body(body.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
        Assertions.assertEquals((new JSONObject(postJson.getBody().asString()).get("name")), (name), "Fail");
        Assertions.assertEquals((new JSONObject(postJson.getBody().asString()).get("job")), (job), "Fail");
        String id = new JSONObject(postJson.getBody().asString()).getString("id");
        String time = new JSONObject(postJson.getBody().asString()).getString("createdAt");
        System.out.println("id пользователя: " + id);
        System.out.println("Время создания профиля: " + time);
    }
}