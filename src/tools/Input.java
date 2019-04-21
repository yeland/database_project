package tools;

import model.Student;

import java.util.Scanner;

public class Input {
    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static Student getStudent() {
        String studentInfo = Input.getInput();
        String[] infos = studentInfo.split(", ");
        Student student = new Student(Integer.parseInt(infos[0]),infos[1],Integer.parseInt(infos[2]),infos[3]);
        return student;
    }
}
