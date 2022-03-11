package com.tw.money;

public enum Currency {
    RUPEE(1),
    USDOLLAR(76),
    EURO(83.33333333333333);

    private final double baseFactor;

    Currency(double baseFactor){
        this.baseFactor = baseFactor;
    }

    public double convertToBaseFactor(double value){
        return value * baseFactor;
    }
}
