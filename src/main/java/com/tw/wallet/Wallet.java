package com.tw.wallet;

import com.tw.money.Rupee;
import exceptions.InvalidValueException;

public class Wallet {
    private Rupee balance;

    public Wallet() throws InvalidValueException {
        this.balance =  new Rupee(0);
    }

    public Rupee balance() {
        return balance;
    }

    public void add(Rupee rupee) throws InvalidValueException {
        balance = balance.add(rupee);
    }

}
