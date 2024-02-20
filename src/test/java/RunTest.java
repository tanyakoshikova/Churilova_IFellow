import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RunTest {

    @Test
    public void addingNumbers() {
        Main Cal = new Main();
        assertEquals(7, Cal.addition(5, 2));
    }

}