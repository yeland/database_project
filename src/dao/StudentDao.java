package dao;

import model.Student;
import model.Subject;

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
        return new Student(id, studentName, age, sex);
    }

    public Student getStudentByName(String name) throws SQLException {
        String select = "Select * FROM student WHERE name = \"" + name + "\"";
        ResultSet resultSet = Connect.operation(select);
        if (resultSet.next()) {
            return getStudent(resultSet);
        }
        return null;
    }

    public Student getStudentById(int id) throws SQLException {
        String select = "Select * FROM student WHERE id = \"" + id + "\"";
        ResultSet resultSet = Connect.operation(select);
        if (resultSet.next()) {
            return getStudent(resultSet);
        }
        return null;
    }

    public int insertStudent(Student student) {
        String sql = "INSERT student VALUES" + student.toSql();
        int result = Connect.updateOperation(sql);
        return result;
    }

    public int updateStudent(Student student) {
        String sql = "UPDATE student SET name = \"" + student.getName() + "\"" +
                ", age =" + student.getAge() +
                ", sex = \"" + student.getSex() + "\"" +
                "WHERE id =" + student.getId();
        int result = Connect.updateOperation(sql);
        return result;
    }

    public int deleteStudent(String name) {
        String sql = "DELETE FROM student WHERE name = \"" + name + "\"";
        int result = Connect.updateOperation(sql);
        return result;
    }
}
