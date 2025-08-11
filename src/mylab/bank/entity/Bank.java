package mylab.bank.entity;

import mylab.bank.exception.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * ���� �ý����� �ֿ� ���� Ŭ����
 */
public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    // ���� ���� ����
    public Account createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("Saving(����) ���°� �����Ǿ����ϴ�: " + account);
        return account;
    }

    // üŷ ���� ����
    public Account createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + account);
        return account;
    }
    
    // ���� �˻�
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }

    // ��� ���� ���� ���
    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    // ���� ��ü
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount); // ���
        System.out.println(String.format("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��", amount, fromAccount.getBalance()));
        
        toAccount.deposit(amount); // �Ա�
        
        System.out.println(String.format("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.", amount, fromAccountNumber, toAccountNumber));
    }
}