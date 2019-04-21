package model;

public class Score {
    private Subject subject;
    private Student student;
    private double number;

    public Score(Subject subject, Student student, double number) {
        this.subject = subject;
        this.student = student;
        this.number = number;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
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
        return subject.getName() + "：" + number;
    }
}
