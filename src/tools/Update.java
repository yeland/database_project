package tools;

import dao.StudentDao;
import model.Student;

import java.sql.SQLException;

public class Update {
    public void updateChoose(String chooseString) throws SQLException {
        switch (chooseString) {
            case "3.1":
                modifyStudent();
                break;
            case "3.2":
                break;
            case "3.3":
                break;
            case "3.4":
                break;
            default:
                break;
        }
    }

    private void modifyStudent() {
        System.out.println("请输入学生学号及其他信息(例如：1001，小明, 18, 男)：");
        Student student = Input.getStudent();
        StudentDao studentDao = new StudentDao();
        int result = studentDao.updateStudent(student);
        if(result != 0) {
            System.out.println("修改学生["+student.getName()+ ", " + student.getId() + "]成功");
        }
    }
}
