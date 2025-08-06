package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentManager {
    public static void main(String[] args) {
        try {
            // ��ȿ�� �г����� ��ü ����
            Student student1 = new Student("S1001", "��μ�", "��ǻ�Ͱ���", 3);
            System.out.println(student1.getName() + "/" + student1.getMajor() + "/" + student1.getGrade() + "�г�");

            // ��ȿ���� ���� �г����� ���� �õ�
            System.out.println("5�г����� ����");
            student1.setGrade(5); 
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage()); // ���� �޽��� ���
        }
    }
}