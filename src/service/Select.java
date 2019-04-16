package service;

import dao.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    public static void selectAllStudent() throws SQLException {
        String select = "Select * FROM student";
        ResultSet resultSet = Connect.operation(select);
        while (resultSet.next()) {
            getStudent(resultSet);
        }
    }

    private static void getStudent(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String studentName = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String sex = resultSet.getString("sex");
        System.out.println("学号： " + id + ", 姓名： " + studentName + ", 年龄： " + age + ", 性别： " + sex);
    }

}
