package mylab.student.exception;

public class InvalidGradeException extends Exception {
    public InvalidGradeException(String errorMessage) { 
        // �θ� Ŭ����(Exception)�� �����ڸ� ȣ���մϴ�. 
        super(errorMessage);
    }
}