package tools;

import dao.ScoreDao;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import model.Student;

import java.sql.SQLException;

public class Delete {
    public void deleteChoose(String chooseString) throws SQLException {
        switch (chooseString) {
            case "4.1":
                deleteStudent();
                break;
            case "4.2":
                deleteSubject();
                break;
            case "4.3":
                deleteTeacher();
                break;
            default:
                break;
        }
    }

    private void deleteStudent() throws SQLException {
        System.out.println("请输入学生姓名：");
        String name = Input.getInput();
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.getStudentByName(name);
        ScoreDao scoreDao = new ScoreDao();
        int studentResult = studentDao.deleteStudent(name);
        int scoreResult = scoreDao.deleteScoreByStudent(student);
        if (studentResult != 0 && scoreResult != 0) {
            System.out.println("删除成功！");
        }
    }

    private void deleteSubject() {
        System.out.println("请输入课程名称：");
        String name = Input.getInput();
        SubjectDao subjectDao = new SubjectDao();
        int result = subjectDao.deleteSubject(name);
        if (result != 0) {
            System.out.println("删除成功！");
        }
    }

    private void deleteTeacher() {
        System.out.println("请输入老师姓名：");
        String name = Input.getInput();
        TeacherDao teacherDao = new TeacherDao();
        int result = teacherDao.deleteTeacher(name);
        if (result != 0) {
            System.out.println("删除成功！");
        }
    }
}
