package tools;

import dao.StudentDao;
import model.Student;

public class Update {
    public void insert(String chooseString) {
        switch (chooseString) {
            case "2.1":
                insertStudent();
                break;

        }
    }

    public void insertStudent() {
        System.out.println("请输入学生信息(例如：1001，小明, 18, 男)：");
        String studentInfo = Input.getInput();
        String[] infos = studentInfo.split(", ");
        Student student = new Student(Integer.parseInt(infos[0]),infos[1],Integer.parseInt(infos[2]),infos[3]);
        StudentDao studentDao = new StudentDao();
        int result = studentDao.insertStudent(student);
        if(result != 0) {
            System.out.println("添加学生["+student.getName()+ ", " + student.getId() + "]成功");
        }
    }
}
