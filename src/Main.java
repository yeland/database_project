import service.CheckLoad;
import service.ChooseOperation;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CheckLoad.load();
        ChooseOperation chooseOperation = new ChooseOperation();
        chooseOperation.choose();

    }
}
