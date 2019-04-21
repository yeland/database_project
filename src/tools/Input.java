package tools;

import model.Student;
import model.Subject;
import model.Teacher;

import java.util.Scanner;

public class Input {
    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static Student getStudent() {
        String studentInfo = Input.getInput();
        String[] infos = studentInfo.split(", ");
        Student student = new Student(Integer.parseInt(infos[0]),infos[1],Integer.parseInt(infos[2]),infos[3]);
        return student;
    }

    public static Subject getSubject() {
        String subjectInfo = Input.getInput();
        String[] infos = subjectInfo.split(", ");
        Subject subject = new Subject(Integer.parseInt(infos[0]),infos[1],infos[2],infos[3]);
        return subject;
    }

    public static Teacher getTeacher() {
        String teacherInfo = Input.getInput();
        String[] infos = teacherInfo.split(", ");
        Teacher teacher = new Teacher(Integer.parseInt(infos[0]),infos[1],Integer.parseInt(infos[2]),infos[3]);
        return teacher;
    }
}
