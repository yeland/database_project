package service;

import dao.StudentDao;
import model.Student;
import tools.Input;
import tools.Print;

import java.sql.SQLException;
import java.util.List;

public class ChooseOperation {
    public void choose() throws SQLException {
        String chooseString = Input.getInput();
        switch (chooseString) {
            case "1.1.1":
                StudentDao studentDao = new StudentDao();
                List<Student> students = studentDao.getAllStudents();
                students.forEach(System.out::println);
                break;
            case "1.1.2":

            case "1.1.3":

        }
    }
}
