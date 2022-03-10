package com.tw.wallet;

public class Wallet {
    private float balance;

    public Wallet() {
        this.balance = 0;
    }

    public float balance() {
        return balance;
    }

    public void add(float rupee) {
        balance = balance + rupee;
    }
}
