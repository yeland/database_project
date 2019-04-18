package model;

public class Score {
    private String subject;
    private double number;

    public Score(String subject, double number) {
        this.subject = subject;
        this.number = number;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
