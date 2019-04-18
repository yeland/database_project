package dao;

import model.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    public List<Subject> getSubjects() throws SQLException {
        String select = "Select * FROM subject";
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
}
