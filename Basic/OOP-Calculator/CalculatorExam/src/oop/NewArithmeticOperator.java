package oop;

public interface NewArithmeticOperator {
    boolean supports(String operator);

    int calculate(int operand1, int operand2);
}
