package com.tw.money;

import exceptions.InvalidValueException;

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
        return Float.compare(rupee.value, this.value) == 0;
    }

    public Rupee add(Rupee rupee) throws InvalidValueException {
        return new Rupee(this.value + rupee.value);
    }
}
