package com.tw.money;

import exceptions.InvalidValueException;

public class Rupee {

    private final double value;

    public Rupee(double value) throws InvalidValueException {
        if(value < 0){
            throw new InvalidValueException();
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(o.getClass() == USD.class){
            USD usd = (USD) o;
            return usd.compareRupee(this.value) == 0;
        }
        else if(o.getClass() == Euro.class){
            Euro euro = (Euro) o;
            return euro.compareRupee(this.value) == 0;
        }


        if (o == null || this.getClass() != o.getClass()) return false;

        Rupee rupee = (Rupee) o;
        return Double.compare(rupee.value, this.value) == 0;
    }


    public Rupee add(Rupee rupee) throws InvalidValueException {
        return new Rupee(this.value + rupee.value);
    }
}
