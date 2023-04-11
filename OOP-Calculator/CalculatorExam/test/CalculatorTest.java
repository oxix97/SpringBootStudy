import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    @DisplayName("덧셈 연산")
    @MethodSource("formulaAndResult")
    @ParameterizedTest
    void addTest(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculate(operand1, operand2, operator);
        Assertions.assertEquals(calculateResult, result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                Arguments.arguments(1, "+", 2, 3),
                Arguments.arguments(1, "-", 2, -1),
                Arguments.arguments(1, "*", 3, 3),
                Arguments.arguments(4, "/", 2, 2)
        );
    }
}
