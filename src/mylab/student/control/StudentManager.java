// StudentManager.java - Control Ŭ����
package mylab.student.control;

import mylab.student.entity.Student;

public class StudentManager {
    public static void main(String[] args) {
        // �л� ��ü ����
        Student student = new Student("20210001", "��μ�", "��ǻ�Ͱ���", 3);
        
        // �л� ���� ���
        System.out.println(student);
        
        // �߸��� �г����� ���� �õ�
        System.out.println("5�г����� ����");
        student.setGrade(5);
    }
}