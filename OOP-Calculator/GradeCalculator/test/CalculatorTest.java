import domain.Course;
import domain.Courses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    @Test
    void calculateGradeTest() {
        Courses courses = new Courses(List.of(
                new Course("OOP", 3, "A+"),
                new Course("PPO", 3, "A+")));
        Calculator calculator = new Calculator(courses);
        double result = calculator.calculate();
        Assertions.assertEquals(4.5, result);
    }
}