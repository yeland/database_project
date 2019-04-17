package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class UserService {
    public int login(String name,String password) throws SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.getUser(name, password);
        if (user == null) {
            return 0;
        }
        return user.getRole().getId();
    }
}
