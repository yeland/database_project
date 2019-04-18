package model;

public class Subject {
    private int id;
    private String name;
    private String teacher;
    private String description;

    public Subject(int id, String name, String teacher, String description) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.description = description;
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

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "课程编号：" + id +
                ", 课程名称：" + name +
                ", 授课教师：" + teacher +
                ", 描述：" + description;
    }
}
