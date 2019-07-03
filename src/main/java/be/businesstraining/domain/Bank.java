package be.businesstraining.domain;

import org.springframework.beans.factory.annotation.Value;

public class Bank {

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Value("${bank.initialvalue}")
    private int balance;

}