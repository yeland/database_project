package tools;

import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import model.Student;
import model.Subject;
import model.Teacher;
import tools.Input;
import tools.Print;

import java.sql.SQLException;
import java.util.List;

public class ChooseOperation {
    public void choose() throws SQLException {
        String chooseString = Input.getInput();
        StudentDao studentDao = new StudentDao();
        SubjectDao subjectDao = new SubjectDao();
        TeacherDao teacherDao = new TeacherDao();
        switch (chooseString) {
            case "1.1.1":
                List<Student> students = studentDao.getAllStudents();
                students.forEach(System.out::println);
                break;
            case "1.1.2":
                System.out.println("请输入学生姓名：");
                String name = Input.getInput();
                Student student = studentDao.getStudentByName(name);
                System.out.println(student);
                break;
            case "1.2.1":
                List<Subject> subjects = subjectDao.getSubjects();
                subjects.forEach(System.out::println);
                break;
            case "1.2.2":
                System.out.println("请输入课程名称：");
                String subjectName = Input.getInput();
                Subject subject = subjectDao.getSubjectByName(subjectName);
                System.out.println(subject);
                break;
            case "1.3.1":
                List<Teacher> teachers = teacherDao.getAllTeachers();
                teachers.forEach(System.out::println);
                break;
            case "1.3.2":
                System.out.println("请输入老师姓名：");
                String teacherName = Input.getInput();
                Teacher teacher = teacherDao.getTeacherByName(teacherName);
                System.out.println(teacher);
                break;
        }
    }
}
