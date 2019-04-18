package dao;

import model.Score;
import model.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreDao {
    public List<Score> getScore(int student_id) throws SQLException {
        String select = "Select * FROM score WHERE student_id = \"" + student_id + "\"";
        ResultSet resultSet = Connect.operation(select);
        List<Score> scores = new ArrayList<>();
        while (resultSet.next()) {
            int subject_id = resultSet.getInt("subject_id");
            double score = resultSet.getDouble("score");
            SubjectDao subjectDao = new SubjectDao();
            Subject subject = subjectDao.getSubjectById(subject_id);
            scores.add(new Score(subject.getName(),score));
        }
        return scores;
    }
}
