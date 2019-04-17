package service;

import dao.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    /*public static void selectAllStudent() throws SQLException {
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
    }*/

    /*public static void selectStudent(String name) throws SQLException {
        String select1 = "Select * FROM student WHERE name = \"" + name + "\"";
        ResultSet resultSet1 = Connect.operation(select1);
        if (resultSet1.next()) {
            getStudent(resultSet1);
        }
        String select2 = "SELECT * FROM student_subject_score WHERE name = \"" + name + "\"";
        ResultSet resultSet2 = Connect.operation(select2);
        while (resultSet2.next()) {
            String subjectName = resultSet2.getString("subject");
            double score = resultSet2.getDouble("score");
            System.out.println(subjectName + ":" + score);
        }
    }*/

    public static void selectTeacherSuent(String name) {

    }

}
