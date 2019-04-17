package tools;

import service.UserService;

import java.sql.SQLException;

public class CommandLogin {
    public void inputLogin() throws SQLException {
        Print.loadIn();
        String userInfo = Input.getInput();
        int chooseRole = checkLogin(userInfo);
        while (chooseRole == 0) {
            Print.inCorrect();
            userInfo = Input.getInput();
            chooseRole = checkLogin(userInfo);
        }
        switch (chooseRole) {
            case 1:
                Print.managerScreen();
                break;
        }
    }

    public int checkLogin(String input) throws SQLException {
        String[] info = input.split(":");
        String name = info[0];
        String password = info[1];
        UserService userService = new UserService();
        return userService.login(name, password);
    }
}
