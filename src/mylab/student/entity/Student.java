package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
    // 1. private �ʵ� �ۼ�
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // ������
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.major = major;
        
        try {
           setGrade(grade);
        } catch (InvalidGradeException e) {
            System.err.println(e.getMessage());
            this.grade = 1; 
        }
    }

    // ��� �ʵ忡 ���� getter �޼���
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    // setGrade �޼���� ������ �����ϰ� ���ܸ� �����ϴ�.
    public void setGrade(int grade) throws InvalidGradeException {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            throw new InvalidGradeException("�г��� 1~4 ���̿��� �մϴ�.");
        }
    }
}
