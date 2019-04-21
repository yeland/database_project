package tools;

import java.sql.SQLException;

public class ChooseOperation {
    public void choose(String chooseString) throws SQLException {
        String[] numbers = chooseString.split("\\.");
        switch (numbers[0]) {
            case "1":
                Select select = new Select();
                select.selectStudent(chooseString);
                select.selectSubject(chooseString);
                select.selectTeacher(chooseString);
                break;
            case "2":
                Insert insert = new Insert();
                insert.insertChoose(chooseString);
            case "3":
                Update update = new Update();
                update.updateChoose(chooseString);
            default:
                break;
        }

    }


}
