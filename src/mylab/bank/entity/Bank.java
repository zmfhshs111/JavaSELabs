package mylab.bank.entity;

import mylab.bank.exception.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 은행 시스템의 주요 관리 클래스
 */
public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    // 저축 계좌 생성
    public Account createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + account);
        return account;
    }

    // 체킹 계좌 생성
    public Account createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account);
        return account;
    }
    
    // 계좌 검색
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    // 모든 계좌 정보 출력
    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    // 계좌 이체
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount); // 출금
        System.out.println(String.format("%.1f원이 출금되었습니다. 현재 잔액: %.1f원", amount, fromAccount.getBalance()));
        
        toAccount.deposit(amount); // 입금
        
        System.out.println(String.format("%.1f원이 %s에서 %s로 송금되었습니다.", amount, fromAccountNumber, toAccountNumber));
    }
}