package model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private String sex;
    private List<Score> scores;

    public Student(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Score> getScores() {
        return this.scores;
    }

    public void setScores(List<Score> score) {
        this.scores = score;
    }

    @Override
    public String toString() {
        return "学号：" + id +
                ", 姓名：" + name+
                ", 年龄：" + age +
                ", 性别：" + sex;
    }
}
