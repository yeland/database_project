import tools.ChooseOperation;
import tools.CommandLogin;
import tools.Input;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CommandLogin commandLogin = new CommandLogin();
        commandLogin.inputLogin();
        ChooseOperation chooseOperation = new ChooseOperation();
        while (true) {
            String chooseString = Input.getInput();
            if(chooseString.equals("0")) {
                break;
            }
            chooseOperation.choose(chooseString);
        }
    }
}
