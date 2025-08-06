// StudentManager.java - Control 클래스
package mylab.student.control;

import mylab.student.entity.Student;

public class StudentManager {
    public static void main(String[] args) {
        // 학생 객체 생성
        Student student = new Student("20210001", "김민수", "컴퓨터공학", 3);
        
        // 학생 정보 출력
        System.out.println(student);
        
        // 잘못된 학년으로 변경 시도
        System.out.println("5학년으로 변경");
        student.setGrade(5);
    }
}