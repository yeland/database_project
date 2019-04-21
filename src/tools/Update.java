package tools;

import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import model.Student;
import model.Subject;
import model.Teacher;

public class Update {
    public void insert(String chooseString) {
        switch (chooseString) {
            case "2.1":
                addStudent();
                break;
            case "2.2":
                addSubject();
                break;
            case "2.3":
                addTeacher();
                break;
            case "2.4":

        }
    }

    private void addStudent() {
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

    private void addSubject() {
        System.out.println("请输入课程信息(例如：1001, 语文, 王老师, 本次考试比较简单)：");
        String subjectInfo = Input.getInput();
        String[] infos = subjectInfo.split(", ");
        Subject subject = new Subject(Integer.parseInt(infos[0]),infos[1],infos[2],infos[3]);
        SubjectDao subjectDao = new SubjectDao();
        int result = subjectDao.insertSubject(subject);
        if(result != 0) {
            System.out.println("添加课程["+subject.getName()+ ", " + subject.getId() + "]成功");
        }
    }

    private void addTeacher() {
        System.out.println("请输入老师信息(例如：301, 王老师, 45, 男)：");
        String teacherInfo = Input.getInput();
        String[] infos = teacherInfo.split(", ");
        Teacher teacher = new Teacher(Integer.parseInt(infos[0]),infos[1],Integer.parseInt(infos[2]),infos[3]);
        TeacherDao teacherDao = new TeacherDao();
        int result = teacherDao.insertTeacher(teacher);
        if(result != 0) {
            System.out.println("添加老师["+teacher.getName()+ ", " + teacher.getId() + "]成功");
        }
    }

}