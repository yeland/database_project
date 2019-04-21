package tools;

import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import model.Student;
import model.Subject;
import model.Teacher;

import java.sql.SQLException;

public class Update {
    public void updateChoose(String chooseString) throws SQLException {
        switch (chooseString) {
            case "3.1":
                modifyStudent();
                break;
            case "3.2":
                modifySubject();
                break;
            case "3.3":
                modifyTeacher();
                break;
            case "3.4":
                break;
            default:
                break;
        }
    }

    private void modifyStudent() {
        System.out.println("请输入学生学号及其他信息(例如：1001，小明, 18, 男)：");
        Student student = Input.getStudent();
        StudentDao studentDao = new StudentDao();
        int result = studentDao.updateStudent(student);
        if (result != 0) {
            System.out.println("修改学生[" + student.getId() + "]成功");
        }
    }

    private void modifySubject() {
        System.out.println("请输入科目编号及其他信息(例如：1001, 语文, 王老师, 本次考试比较简单)：");
        Subject subject = Input.getSubject();
        SubjectDao subjectDao = new SubjectDao();
        int result = subjectDao.updateSubject(subject);
        if (result != 0) {
            System.out.println("修改科目[" + subject.getId() + "]成功");
        }
    }

    private void modifyTeacher() {
        System.out.println("请输入老师工号及其他信息(例如：301, 王老师, 45, 男)：");
        Teacher teacher = Input.getTeacher();
        TeacherDao teacherDao = new TeacherDao();
        int result = teacherDao.updateTeacher(teacher);
        if(result != 0) {
            System.out.println("修改老师[" + teacher.getId() + "]成功");
        }
    }


}
