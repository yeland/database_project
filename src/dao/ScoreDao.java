package dao;

import model.Score;
import model.Student;
import model.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {
    public List<Score> getScoresBySubject(Subject subject) throws SQLException {
        String select = "Select * FROM score WHERE subject_id = \"" + subject.getId() + "\"";
        ResultSet resultSet = Connect.operation(select);
        List<Score> scores = new ArrayList<>();
        while (resultSet.next()) {
            int student_id = resultSet.getInt("student_id");
            double score = resultSet.getDouble("score");
            StudentDao studentDao = new StudentDao();
            Student student = studentDao.getStudentById(student_id);
            scores.add(new Score(subject, student, score));
        }
        return scores;
    }

    public List<Score> getScoresByStudent(Student student) throws SQLException {
        String select = "Select * FROM score WHERE student_id = \"" + student.getId() + "\"";
        ResultSet resultSet = Connect.operation(select);
        List<Score> scores = new ArrayList<>();
        while (resultSet.next()) {
            int subject_id = resultSet.getInt("subject_id");
            double score = resultSet.getDouble("score");
            SubjectDao subjectDao = new SubjectDao();
            Subject subject = subjectDao.getSubjectById(subject_id);
            scores.add(new Score(subject, student, score));
        }
        return scores;
    }
}
