package testClasses;

import hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static Steps.CreateUserSteps.createUser;
import static Steps.RickAndMortySteps.*;

public class Tests extends WebHooks {

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"2"})
    @DisplayName("Проверка совпадения расы и местонахождения найденного персонажа и Морти")
    public void RickAndMortyTest(String id) {
        getDataMorty(id);
        getLastEpisode();
        getCharacter();
        getDataCharacter();
        checkData();
    }

    @ParameterizedTest
    @CsvSource({"Tomato,Eat market"})
    public void ReqRestTest(String name, String job) throws IOException {
        createUser(name, job);
    }
}

