package com.tw.money;

import exceptions.InvalidValueException;

public class USD {

    private final double value;

    public USD(double value) throws InvalidValueException {
        if(value < 0){
            throw new InvalidValueException();
        }
        this.value = value;
    }

    public int compareRupee(double value){
        double actualRupee = value;
        double usdInRupee = this.value * 76;
        return Double.compare(usdInRupee, actualRupee);
    }

}
