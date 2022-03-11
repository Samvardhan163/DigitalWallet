package com.tw.money;

public enum Currency {
    RUPEE(1),
    USDOLLAR(76),
    EURO(1/0.012);

    private final double baseFactor;

    Currency(double baseFactor){
        this.baseFactor = baseFactor;
    }

    public double convertToBaseFactor(double value){
        return value * baseFactor;
    }
}
