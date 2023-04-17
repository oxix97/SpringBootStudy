package oop;

import java.util.List;

public class OOPCalculator {
    private static final List<NewArithmeticOperator> operators = List.of(
            new Addition(),
            new Subtraction(),
            new Multiplication(),
            new Division()
    );
    public static int calculate(int operand1, int operand2, String operator) {
        return operators.stream()
                .filter(it -> it.supports(operator))
                .map(it -> it.calculate(operand1,operand2))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }
}
