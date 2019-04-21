package tools;

import dao.ScoreDao;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import model.Score;
import model.Student;
import model.Subject;
import model.Teacher;

import java.sql.SQLException;

public class Insert {
    public void insertChoose(String chooseString) throws SQLException {
        switch (chooseString) {
            case "2.1":
                addStudent();
                break;
            case "2.2":
                addSubject();
                break;
            case "2.3":
                addTeacher();
                break;
            case "2.4":
                addStudentScore();
                break;
            default:
                break;
        }
    }

    private void addStudent() {
        System.out.println("请输入学生信息(例如：1001，小明, 18, 男)：");
        Student student = Input.getStudent();
        StudentDao studentDao = new StudentDao();
        int result = studentDao.insertStudent(student);
        if(result != 0) {
            System.out.println("添加学生["+student.getName()+ ", " + student.getId() + "]成功");
        }
    }

    private void addSubject() {
        System.out.println("请输入课程信息(例如：1001, 语文, 王老师, 本次考试比较简单)：");
        Subject subject = Input.getSubject();
        SubjectDao subjectDao = new SubjectDao();
        int result = subjectDao.insertSubject(subject);
        if(result != 0) {
            System.out.println("添加课程["+subject.getName()+ ", " + subject.getId() + "]成功");
        }
    }

    private void addTeacher() {
        System.out.println("请输入老师信息(例如：301, 王老师, 45, 男)：");
        Teacher teacher = Input.getTeacher();
        TeacherDao teacherDao = new TeacherDao();
        int result = teacherDao.insertTeacher(teacher);
        if(result != 0) {
            System.out.println("添加老师["+teacher.getName()+ ", " + teacher.getId() + "]成功");
        }
    }

    private void addStudentScore() throws SQLException {
        System.out.println("请输入学生名字及其成绩(例如：张三, 英语, 86)：");
        Score score = Input.getScore();
        ScoreDao scoreDao = new ScoreDao();
        int result = scoreDao.insertScore(score);
        if(result != 0) {
            System.out.println("添加成绩成功");
        }
    }
}
