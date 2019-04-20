package tools;

import dao.ScoreDao;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import model.Score;
import model.Student;
import model.Subject;
import model.Teacher;
import tools.Input;
import tools.Print;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ChooseOperation {
    public void choose() throws SQLException {
        String chooseString = Input.getInput();
        StudentDao studentDao = new StudentDao();
        SubjectDao subjectDao = new SubjectDao();
        TeacherDao teacherDao = new TeacherDao();
        ScoreDao scoreDao = new ScoreDao();
        switch (chooseString) {
            case "1.1.1":
                List<Student> students = studentDao.getAllStudents();
                students.forEach(System.out::println);
                break;
            case "1.1.2":
                System.out.println("请输入学生姓名：");
                String name = Input.getInput();
                Student student = studentDao.getStudentByName(name);
                List<Score> scores = scoreDao.getScoresByStudent(student);
                System.out.println(student);
                scores.forEach(System.out::println);
                break;
            case "1.1.3":
                System.out.println("请输入老师姓名：");
                String teacherName = Input.getInput();
                List<Subject> subjects = subjectDao.getSubjectsByTeacher(teacherName);
                subjects.forEach(subject -> {
                    try {
                        getScoresBySubject(subject.getName());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            case "1.1.4":
                System.out.println("请输入课程名称：");
                String subjectName = Input.getInput();
                getScoresBySubject(subjectName);
                break;
            case "1.2.1":
                List<Subject> subjects1 = subjectDao.getAllSubjects();
                subjects1.forEach(System.out::println);
                break;
            case "1.2.2":
                System.out.println("请输入课程名称：");
                String subjectName1 = Input.getInput();
                Subject subject1 = subjectDao.getSubjectByName(subjectName1);
                System.out.println(subject1);
                break;
            case "1.2.3":
                System.out.println("请输入老师姓名：");
                String teacherName1 = Input.getInput();
                List<Subject> subjects2 = subjectDao.getSubjectsByTeacher(teacherName1);
                subjects2.forEach(System.out::println);
                break;
            case "1.3.1":
                List<Teacher> teachers = teacherDao.getAllTeachers();
                teachers.forEach(System.out::println);
                break;
            case "1.3.2":
                System.out.println("请输入老师姓名：");
                String teacherName2 = Input.getInput();
                Teacher teacher = teacherDao.getTeacherByName(teacherName2);
                System.out.println(teacher);
                break;
        }
    }

    private void getScoresBySubject(String subjectName) throws SQLException {
        SubjectDao subjectDao = new SubjectDao();
        ScoreDao scoreDao = new ScoreDao();
        Subject subject = subjectDao.getSubjectByName(subjectName);
        List<Score> scores = scoreDao.getScoresBySubject(subject);
        List<Score> scoresSubject = scores.stream().filter(score -> score.getSubject().equals(subjectName))
                .collect(Collectors.toList());
        scoresSubject.forEach(score -> System.out.println(score.getStudent() + ", " + score));
    }
}
