package dao;

import model.Student;
import model.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    public List<Subject> getAllSubjects() throws SQLException {
        String select = "Select * FROM subject";
        return getSubjects(select);
    }

    public List<Subject> getSubjects(String select) throws SQLException {
        ResultSet resultSet = Connect.operation(select);
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next()) {
            subjects.add(getSubject(resultSet));
        }
        return subjects;
    }

    private Subject getSubject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("subject");
        String teacher = resultSet.getString("teacher");
        String description = resultSet.getString("description");
        return new Subject(id,name,teacher,description);
    }

    public Subject getSubjectByName(String name) throws SQLException {
        String select = "Select * FROM subject WHERE subject = \"" + name + "\"";
        ResultSet resultSet = Connect.operation(select);
        if (resultSet.next()) {
            return getSubject(resultSet);
        }
        return null;
    }

    public Subject getSubjectById(int id) throws SQLException {
        String select = "Select * FROM subject WHERE id = \"" + id + "\"";
        ResultSet resultSet = Connect.operation(select);
        if (resultSet.next()) {
            return getSubject(resultSet);
        }
        return null;
    }

    public List<Subject> getSubjectsByTeacher(String teacherName) throws SQLException {
        String select = "Select * FROM subject WHERE teacher = \"" + teacherName + "\"";
        return getSubjects(select);
    }

    public int insertSubject(Subject subject) {
        String sql = "INSERT subject VALUES" + subject.toSql();
        int result = Connect.updateOperation(sql);
        return result;
    }

    public int updateSubject(Subject subject) {
        String sql = "UPDATE subject SET subject = \"" + subject.getName() + "\"" +
                ", teacher = \"" + subject.getTeacher() + "\"" +
                ", description = \"" + subject.getDescription() + "\"" +
                "WHERE id =" + subject.getId();
        int result = Connect.updateOperation(sql);
        return result;
    }

    public int deleteSubject(String name) {
        String sql = "DELETE FROM subject WHERE subject = \"" + name + "\"";
        int result = Connect.updateOperation(sql);
        return result;
    }
}
