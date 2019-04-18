package model;

public class Score {
    private String subject;
    private Student student;
    private double number;

    public Score(String subject, Student student, double number) {
        this.subject = subject;
        this.student = student;
        this.number = number;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getNumber() {
        return this.number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return subject + "：" + number;
    }
}
