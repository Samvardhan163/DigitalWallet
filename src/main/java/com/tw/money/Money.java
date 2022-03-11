package com.tw.money;

import exceptions.InvalidValueException;

import java.util.Objects;

public class Money {
    private final double value;
    private final Currency currency;

    private Money(double value, Currency currency) throws InvalidValueException {
        if(value < 0){
            throw new InvalidValueException();
        }
        this.value = value;
        this.currency = currency;
    }

    public static Money newRupee(double value) throws InvalidValueException {
        return new Money(value, Currency.RUPEE);
    }

    public static Money newUSDollar(double value) throws InvalidValueException {
        return new Money(value, Currency.USDOLLAR);
    }

    public static Money newEuro(double value) throws InvalidValueException {
        return new Money(value, Currency.EURO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Money anotherMoney = (Money) o;
        return currency.convertToBaseFactor(value) == anotherMoney.currency.convertToBaseFactor(anotherMoney.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency.convertToBaseFactor(value));
    }

    public Money add(Money anotherMoney) throws InvalidValueException {
        if(this.currency == anotherMoney.currency){
            double newValue = this.value + anotherMoney.value;
            return new Money( newValue,this.currency);
        }

        // add feature to add other currency
        return null;
    }
}
