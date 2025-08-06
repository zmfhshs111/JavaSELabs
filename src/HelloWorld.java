package mylab.student.entity;

public class Student {
    // 모든 필드를 private으로 캡슐화
    private String studentId;
    private String name;
    private String major;
    private int grade;
    
    // 기본 생성자
    public Student() {
    }
    
    // 매개변수 생성자
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        setGrade(grade); // setter 사용하여 유효성 검사
    }
    
    // getter 메서드들
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
    
    // setter 메서드들
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    // 학년 설정 시 1~4 범위 검증
    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            System.out.println("학년은 1~4 사이여야 합니다.");
        }
    }
    
    // toString 메서드
    @Override
    public String toString() {
        return name + " / " + major + " / " + grade + "학년";
    }
}
