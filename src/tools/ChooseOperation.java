package tools;

import dao.StudentDao;
import model.Student;
import tools.Input;
import tools.Print;

import java.sql.SQLException;
import java.util.List;

public class ChooseOperation {
    public void choose() throws SQLException {
        String chooseString = Input.getInput();
        StudentDao studentDao = new StudentDao();
        switch (chooseString) {
            case "1.1.1":
                List<Student> students = studentDao.getAllStudents();
                students.forEach(System.out::println);
                break;
            case "1.1.2":
                Print.inputStudentName();
                String name = Input.getInput();
                Student student = studentDao.getStudentByName(name);
                System.out.println(student);
            case "1.1.3":

        }
    }
}
