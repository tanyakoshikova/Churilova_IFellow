package hooks;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {
    @BeforeEach
    public void beforeEach (){
        RestAssured.filters(new AllureRestAssured());
    }
}