package com.tw.money;

import exceptions.InvalidValueException;

import java.util.Objects;

public class Rupee {

    private final float value;

    public Rupee(float value) throws InvalidValueException {
        if(value < 0){
            throw new InvalidValueException();
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rupee rupee = (Rupee) o;
        return Float.compare(rupee.hashCode(), hashCode()) == 0;
    }

    public float value(){
        return value;
    }

    public Rupee add(Rupee rupee) throws InvalidValueException {
        return new Rupee(this.value + rupee.value);
    }
}
