import domain.Courses;

public class Calculator {
    private final Courses courses;

    public Calculator(Courses courses) {
        this.courses = courses;
    }

    public double calculate() {
        return courses.totalPoint() / courses.totalCredit();
    }
}
