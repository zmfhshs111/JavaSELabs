package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

/**
 * 은행 시스템의 기능을 테스트하는 클래스 (수정됨)
 */
public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        Account acc1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
        Account acc2 = bank.createCheckingAccount("김철수", 20000, 5000);
        Account acc3 = bank.createSavingsAccount("이영희", 30000, 2.0);

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            acc1.deposit(5000);
            acc2.withdraw(3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        if (acc1 instanceof SavingsAccount) {
            // Sample Run 결과에 맞추기 위해 캐스팅하여 호출
            ((SavingsAccount) acc1).applyInterest();
        }

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        System.out.println("\n=== 예외 처리 테스트 ===");
        try {
            acc2.withdraw(6000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        try {
             acc2.withdraw(5000.1); // 출금 한도를 초과하는 다른 케이스
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}