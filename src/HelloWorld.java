package mylab.student.entity;

public class Student {
    // ��� �ʵ带 private���� ĸ��ȭ
    private String studentId;
    private String name;
    private String major;
    private int grade;
    
    // �⺻ ������
    public Student() {
    }
    
    // �Ű����� ������
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        setGrade(grade); // setter ����Ͽ� ��ȿ�� �˻�
    }
    
    // getter �޼����
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
    
    // setter �޼����
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    // �г� ���� �� 1~4 ���� ����
    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            System.out.println("�г��� 1~4 ���̿��� �մϴ�.");
        }
    }
    
    // toString �޼���
    @Override
    public String toString() {
        return name + " / " + major + " / " + grade + "�г�";
    }
}
