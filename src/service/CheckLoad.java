package service;

import dao.Connect;
import model.User;
import tools.Input;
import tools.Print;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoad {
    public static void load() {
        Print.loadIn();
        String userInfo = Input.getInput();
        boolean load = CheckLoad.isCorrect(userInfo);
        while (!load) {
            Print.inCorrect();
            userInfo = Input.getInput();
            load = CheckLoad.isCorrect(userInfo);
        }
        Print.managerScreen();
    }

    public static boolean isCorrect(String input) {
        CheckLoad checkLoad = new CheckLoad();
        User user = checkLoad.getUser(input);
        String selectUser = "Select password FROM manager WHERE name=\""+user.getName()+"\"";
        ResultSet resultSet = Connect.operation(selectUser);
        int password = 0;
        try {
            if(resultSet.next()) {
                password = resultSet.getInt("password");
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(password != user.getPassword()) {
            return false;
        }
        return true;
    }

    private User getUser(String input) {
        String[] userInfo = input.split(":");
        String name = userInfo[0];
        int password = Integer.parseInt(userInfo[1]);
        return new User(name,password);
    }
}
