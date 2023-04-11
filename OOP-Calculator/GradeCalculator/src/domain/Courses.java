package domain;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public int totalCredit() {
        return courses.stream().mapToInt(Course::getCredit).sum();
    }

    public double totalPoint() {
        return courses.stream().mapToDouble(Course::getTotalPoint).sum();
    }
}
