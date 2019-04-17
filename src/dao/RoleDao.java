package dao;

import model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDao {
    public Role getRole(int id) throws SQLException {
        String selectRole = "Select name FROM role WHERE id = \"" + id + "\"";
        ResultSet resultSet = Connect.operation(selectRole);
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            return new Role(id, name);
        } else {
            return null;
        }
    }
}
