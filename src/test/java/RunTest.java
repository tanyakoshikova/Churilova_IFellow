import  org.example.MathematicalOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunTest {

    @Test
    public void addingNumbers() {
        MathematicalOperations Cal = new MathematicalOperations();
        Assertions.assertEquals(7, Cal.addition(5, 2));
    }

    @Test
    public void multiplyNumbers(){
        MathematicalOperations Call = new MathematicalOperations();
        Assertions.assertEquals(6, Call.multiply(3,2));
    }

    MathematicalOperations calculator;
    @BeforeEach
    void setUp() {
        calculator = new MathematicalOperations();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void multiply() {
        Assertions.assertEquals(20, calculator.multiply(4, 5), "Regular multiplication should work");
    }

    @Test
    public void compare() {
        MathematicalOperations basicTests = new MathematicalOperations();
        int value = basicTests.compare(2, 1);
        Assertions.assertEquals(1, value);
    }

 }