package com.tw.money;

import exceptions.InvalidValueException;

public class Euro {

    private double value;

    public Euro(double value) throws InvalidValueException {
        if(value < 0){
            throw new InvalidValueException();
        }
        this.value = value;
    }

    public int compareRupee(double value) {
        double actualRupee = value;
        double euroInRupee = this.value * 83.33333333333333;
        return Double.compare(euroInRupee, actualRupee);
    }
}
