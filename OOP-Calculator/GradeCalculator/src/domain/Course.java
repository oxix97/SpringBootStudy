package domain;

public class Course {
    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return this.credit;
    }

    private double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+" -> grade = 4.5;
            case "A" -> grade = 4.0;
            case "B+" -> grade = 3.5;
            case "B" -> grade = 3.0;
            case "C+" -> grade = 2.5;
            case "C" -> grade = 2.0;
            case "D" -> grade = 1.0;
            default -> grade = 0;
        }
        return grade;
    }

    public double getTotalPoint() {
        return getGradeToNumber() * getCredit();
    }
}
