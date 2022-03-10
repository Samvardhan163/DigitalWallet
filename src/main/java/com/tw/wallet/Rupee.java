package com.tw.wallet;

import exceptions.InvalidValueException;

public class Rupee {

    private float value;

    public Rupee(float value) throws InvalidValueException {
        if(value <= 0){
            throw new InvalidValueException();
        }
        this.value = value;
    }

    public float value(){
        return value;
    }
}
