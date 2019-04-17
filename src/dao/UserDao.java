package dao;

import model.Role;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getUser(String name, String password) throws SQLException {
        String selectUser = "Select * FROM user WHERE name = \"" + name + "\"" +
                "AND password = \"" + password + "\"";
        ResultSet resultSet = Connect.operation(selectUser);
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            int role_id = resultSet.getInt("role_id");
            RoleDao roleDao = new RoleDao();
            Role role = roleDao.getRole(role_id);
            return new User(id, name, password, role);
        } else {
            return null;
        }
    }
}