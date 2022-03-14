package com.tw.money;

import exceptions.InvalidValueException;

import java.util.Objects;

public class Money {
    private final double value;
    private final Currency currency;

    private Money(double value, Currency currency) throws InvalidValueException {
        if (value < 0) {
            throw new InvalidValueException();
        }
        this.value = value;
        this.currency = currency;
    }

    public static Money createRupee(double value) throws InvalidValueException {
        return new Money(value, Currency.rupee);
    }

    public static Money createUsDollar(double value) throws InvalidValueException {
        return new Money(value, Currency.usDollar);
    }

    public static Money createEuro(double value) throws InvalidValueException {
        return new Money(value, Currency.euro);
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
        double newValue = this.value + anotherMoney.currency.convertToBaseFactor(anotherMoney.value);
        return new Money((float)newValue, this.currency);

    }
}
