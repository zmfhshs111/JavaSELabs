package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

/**
 * ���� �ý����� ����� �׽�Ʈ�ϴ� Ŭ���� (������)
 */
public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        Account acc1 = bank.createSavingsAccount("ȫ�浿", 10000, 3.0);
        Account acc2 = bank.createCheckingAccount("��ö��", 20000, 5000);
        Account acc3 = bank.createSavingsAccount("�̿���", 30000, 2.0);

        System.out.println("\n=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================");

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        try {
            acc1.deposit(5000);
            acc2.withdraw(3000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        if (acc1 instanceof SavingsAccount) {
            // Sample Run ����� ���߱� ���� ĳ�����Ͽ� ȣ��
            ((SavingsAccount) acc1).applyInterest();
        }

        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================");

        System.out.println("\n=== ���� ó�� �׽�Ʈ ===");
        try {
            acc2.withdraw(6000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        
        try {
             acc2.withdraw(5000.1); // ��� �ѵ��� �ʰ��ϴ� �ٸ� ���̽�
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}