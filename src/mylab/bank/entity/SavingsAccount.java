package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

/**
 * 저축 계좌를 표현하는 클래스로 Account 클래스를 상속
 */
public class SavingsAccount extends Account {
    private double interestRate; // 이자율

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        balance -= amount;
        // 문제의 Sample Run과 출력을 맞추기 위해 출금 성공 메시지는 transfer 메소드에서 처리하도록 주석처리
        // System.out.println(String.format("%.1f원이 출금되었습니다. 현재 잔액: %.1f원", amount, balance));
    }

    // 이자 적용 기능
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        // Sample Run 에는 '입금'과 '이자 적용' 두가지 메시지가 있지만, 실제로는 이자 적용이 입금의 한 형태이므로
        // 혼동을 줄이기 위해 '이자 적용' 메시지만 출력합니다.
        // System.out.println(String.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원", interest, balance + interest));
        balance += interest;
        System.out.println(String.format("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원", interest, balance));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", 이자율: %.1f%%", interestRate);
    }
}