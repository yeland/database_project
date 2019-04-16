package service;

import tools.Input;
import tools.Print;

import java.sql.SQLException;

public class ChooseOperation {
    public String formatChoose() {
        String chooseString = Input.getInput();
        String[] numbers = chooseString.split("\\.");
        String number = String.join("",numbers);
        return number;
    }

    public void choose() throws SQLException {
        String number = formatChoose();
        switch (number) {
            case "111":
                Select.selectAllStudent();
                break;
            case "112":
                Print.inputStudentName();
                String name = Input.getInput();
                Select.selectStudent(name);
        }
    }
}
