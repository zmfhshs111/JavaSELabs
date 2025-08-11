package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

/**
 * ��� ������ �⺻�� �Ǵ� �߻� Ŭ����
 */
public abstract class Account {
    protected String accountNumber; // ���¹�ȣ
    protected String ownerName;     // ���¼����� �̸�
    protected double balance;       // ���� �ܾ�

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // �Ա�
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(String.format("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��", amount, balance));
        }
    }

    // ��� (�߻� �޼���)
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
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��", accountNumber, ownerName, balance);
    }
}