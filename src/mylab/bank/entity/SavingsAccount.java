package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

/**
 * ���� ���¸� ǥ���ϴ� Ŭ������ Account Ŭ������ ���
 */
public class SavingsAccount extends Account {
    private double interestRate; // ������

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�.");
        }
        balance -= amount;
        // ������ Sample Run�� ����� ���߱� ���� ��� ���� �޽����� transfer �޼ҵ忡�� ó���ϵ��� �ּ�ó��
        // System.out.println(String.format("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��", amount, balance));
    }

    // ���� ���� ���
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        // Sample Run ���� '�Ա�'�� '���� ����' �ΰ��� �޽����� ������, �����δ� ���� ������ �Ա��� �� �����̹Ƿ�
        // ȥ���� ���̱� ���� '���� ����' �޽����� ����մϴ�.
        // System.out.println(String.format("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��", interest, balance + interest));
        balance += interest;
        System.out.println(String.format("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��", interest, balance));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ������: %.1f%%", interestRate);
    }
}