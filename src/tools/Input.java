package tools;

import dao.StudentDao;
import dao.SubjectDao;
import model.Score;
import model.Student;
import model.Subject;
import model.Teacher;

import java.sql.SQLException;
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

    public static Score getScore() throws SQLException {
        String scoreInfo = Input.getInput();
        String[] infos = scoreInfo.split(", ");
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.getStudentByName(infos[0]);
        SubjectDao subjectDao = new SubjectDao();
        Subject subject = subjectDao.getSubjectByName(infos[1]);
        Score score = new Score(subject,student,Double.parseDouble(infos[2]));
        return score;
    }
}
