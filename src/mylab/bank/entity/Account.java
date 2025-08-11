package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

/**
 * 모든 계좌의 기본이 되는 추상 클래스
 */
public abstract class Account {
    protected String accountNumber; // 계좌번호
    protected String ownerName;     // 계좌소유자 이름
    protected double balance;       // 현재 잔액

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 입금
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(String.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원", amount, balance));
        }
    }

    // 출금 (추상 메서드)
    public abstract void withdraw(double amount) throws Exception;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원", accountNumber, ownerName, balance);
    }
}