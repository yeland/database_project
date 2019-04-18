package dao;

import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> getAllStudents() throws SQLException {
        String select = "Select * FROM student";
        ResultSet resultSet = Connect.operation(select);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(getStudent(resultSet));
        }
        return students;
    }

    private Student getStudent(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String studentName = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String sex = resultSet.getString("sex");
        return new Student(id,studentName,age,sex);
    }

    public Student getStudentByName(String name) throws SQLException {
        String select1 = "Select * FROM student WHERE name = \"" + name + "\"";
        ResultSet resultSet = Connect.operation(select1);
        if (resultSet.next()) {
            return getStudent(resultSet);
        }
        return null;
    }

}
