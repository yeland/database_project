package model;

import dao.SubjectDao;

import java.sql.SQLException;
import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private int age;
    private String sex;
    private List<Subject> subjects;

    public Teacher(int id, String name, int age, String sex) {
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

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects() throws SQLException {
        SubjectDao subjectDao = new SubjectDao();
        this.subjects = subjectDao.getSubjectsByTeacher(this.name);
    }

    @Override
    public String toString() {
        return "工号：" + id +
                ", 姓名：" + name+
                ", 年龄：" + age +
                ", 性别：" + sex;
    }

}
