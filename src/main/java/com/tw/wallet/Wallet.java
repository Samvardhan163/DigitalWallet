package com.tw.wallet;

import com.tw.money.Currency;
import com.tw.money.Money;
import exceptions.InvalidValueException;

import static com.tw.money.Money.newRupee;

public class Wallet {
    private Money balance;

    public Wallet() throws InvalidValueException {
        this.balance =  newRupee(0);
    }

    public Money balance() {
        return balance;
    }

    public void add(Money anotherMoney) throws InvalidValueException {
        balance = balance.add(anotherMoney);
    }

}
