package dao;

import model.Student;
import model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    public List<Teacher> getAllTeachers() throws SQLException {
        String select = "Select * FROM teacher";
        ResultSet resultSet = Connect.operation(select);
        List<Teacher> teachers = new ArrayList<>();
        while (resultSet.next()) {
            teachers.add(getTeacher(resultSet));
        }
        return teachers;
    }

    private Teacher getTeacher(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String teacherName = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String sex = resultSet.getString("sex");
        return new Teacher(id,teacherName,age,sex);
    }

    public Teacher getTeacherByName(String name) throws SQLException {
        String select = "Select * FROM teacher WHERE name = \"" + name + "\"";
        ResultSet resultSet = Connect.operation(select);
        if (resultSet.next()) {
            return getTeacher(resultSet);
        }
        return null;
    }

    public int insertTeacher(Teacher teacher) {
        String sql = "INSERT teacher VALUES" + teacher.toSql();
        int result = Connect.updateOperation(sql);
        return result;
    }

    public int updateTeacher(Teacher teacher) {
        String sql = "UPDATE teacher SET name = \"" + teacher.getName() + "\"" +
                ", age =" + teacher.getAge() +
                ", sex = \"" + teacher.getSex() + "\"" +
                "WHERE id =" + teacher.getId();
        int result = Connect.updateOperation(sql);
        return result;
    }

    public int deleteTeacher(String name) {
        String sql = "DELETE FROM teacher WHERE name = \"" + name + "\"";
        int result = Connect.updateOperation(sql);
        return result;
    }
}
