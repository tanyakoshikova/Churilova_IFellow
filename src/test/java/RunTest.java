import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunTest {

    @Test
    public void addingNumbers() {
        Main Cal = new Main();
        Assertions.assertEquals(7, Cal.addition(5, 2));
    }

    @Test
    public void multiplyNumbers(){
        Main Call = new Main();
        Assertions.assertEquals(6, Call.multiply(3,2));
    }

    Main calculator;
    @BeforeEach
    void setUp() {
        calculator = new Main();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void multiply() {
        Assertions.assertEquals(20, calculator.multiply(4, 5), "Regular multiplication should work");
    }

    @Test
    public void compare() {
        Main basicTests = new Main();
        int value = basicTests.compare(2, 1);
        Assertions.assertEquals(1, value);
    }

}