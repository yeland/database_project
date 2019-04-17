import service.UserService;
import service.ChooseOperation;
import tools.CommandLogin;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CommandLogin commandLogin = new CommandLogin();
        commandLogin.inputLogin();
        ChooseOperation chooseOperation = new ChooseOperation();
        chooseOperation.choose();

    }
}
