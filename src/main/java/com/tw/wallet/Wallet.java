package com.tw.wallet;

import com.tw.money.Money;
import exceptions.InvalidValueException;

import static com.tw.money.Money.createRupee;

public class Wallet {
    private Money balance;

    public Wallet() throws InvalidValueException {
        this.balance =  createRupee(0);
    }

    public Money balance() {
        return balance;
    }

    public void add(Money anotherMoney) throws InvalidValueException {
        balance = balance.add(anotherMoney);
    }

}
