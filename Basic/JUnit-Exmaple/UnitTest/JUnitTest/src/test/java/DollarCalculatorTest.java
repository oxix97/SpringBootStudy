import org.example.api.MarketApi;
import org.example.calculator.Calculator;
import org.example.calculator.DollarCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {
    @Mock
    public MarketApi api;

    @BeforeEach
    public void init() {
        Mockito.lenient().when(api.connect()).thenReturn(3000);
    }

    @Test
    public void testHello() {
        System.out.println("hello");
    }

    @Test
    public void dollarTest() {
        MarketApi api = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(api);
        Calculator calculator = new Calculator(dollarCalculator);

        int base = api.connect();
        int a = calculator.sum(1, 2);
        int b = calculator.sum(3, 2);
        int c = calculator.minus(10, 10);

        Assertions.assertEquals(1100, base);
        Assertions.assertEquals(base * 3, a);
        Assertions.assertEquals(base * 5, b);
        Assertions.assertEquals(0, c);
    }

    @Test
    public void mockTest() {
        DollarCalculator dollarCalculator = new DollarCalculator(api);
        Calculator calculator = new Calculator(dollarCalculator);

        int a = calculator.sum(1, 2);
        int b = calculator.sum(3, 2);
        int c = calculator.minus(10, 10);

        Assertions.assertEquals(9000, a);
        Assertions.assertEquals(15000, b);
        Assertions.assertEquals(0, c);
    }
}
