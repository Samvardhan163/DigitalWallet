package com.tw.wallet;

public class Wallet {
    private int amount;

    public Wallet() {
        this.amount = 0;
    }


    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount = this.amount + amount;
    }
}
