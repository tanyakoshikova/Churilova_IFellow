package pages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class RickAndMortySteps {
    public static String idMorty, genderMorty, speciesMorty, locationMorty, nameCharacter, speciesCharacter, locationCharacter;
    public static int lastEpisode, idLastCharacter;

    static RequestSpecification RickAndMortyApi = new RequestSpecBuilder()
            .setBaseUri("https://rickandmortyapi.com/api")
            .build();

    public static void getDataMorty(String id) {
        Response gettingMorty = given()
                .spec(RickAndMortyApi)
                .when()
                .get("/character/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response();
        JSONObject characterJson = new JSONObject(gettingMorty.getBody().asString());
        idMorty = characterJson.get("id").toString();
        genderMorty = characterJson.get("gender").toString();
        speciesMorty = characterJson.get("species").toString();
        locationMorty = characterJson.getJSONObject("location").get("name").toString();
        System.out.println("Информация по персонажу Морти Смит, id персонажа: " + idMorty + ",пол персонажа: " + genderMorty);
    }

    public static void getLastEpisode() {
        Response gettingLastEpisode = given()
                .spec(RickAndMortyApi)
                .when()
                .get("/character/" + idMorty)
                .then()
                .statusCode(200)
                .extract()
                .response();
        int episode = (new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode").length() - 1);
        lastEpisode = Integer.parseInt(new JSONObject(gettingLastEpisode.getBody().asString())
                .getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", ""));
        System.out.println("Последний эпизод, где появлялся Морти: " + lastEpisode);
    }

    public static void getCharacter() {
        Response gettingCharacter = given()
                .spec(RickAndMortyApi)
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .statusCode(200)
                .extract()
                .response();
        int person = (new JSONObject(gettingCharacter.getBody().asString()).getJSONArray("characters").length() - 1);
        idLastCharacter = Integer.parseInt(new JSONObject(gettingCharacter.getBody().asString())
                .getJSONArray("characters").get(person).toString().replaceAll("[^0-9]", ""));
        System.out.println("Из списка последнего эпизода id последнего персонажа: " + idLastCharacter);
    }

    public static void getDataCharacter() {
        Response gettingDataCharacter = given()
                .spec(RickAndMortyApi)
                .when()
                .get("/character/" + idLastCharacter)
                .then()
                .statusCode(200)
                .extract()
                .response();
        JSONObject personJson = new JSONObject(gettingDataCharacter.getBody().asString());
        nameCharacter = personJson.getString("name");
        speciesCharacter = personJson.getString("species");
        locationCharacter = personJson.getJSONObject("location").getString("name");
        System.out.println("Данные по местонахождению и расе персонажа: " + locationCharacter + ", " + speciesCharacter);
        System.out.println("Данные по местонахождению и расе Морти: " + locationMorty + ", " + speciesMorty);
    }

    public static void checkData() {
        Assert.assertEquals("Расы отличаются => ", speciesCharacter, speciesMorty);
        Assert.assertEquals("Места нахождения отличаются => ", locationCharacter, locationMorty);
    }
}