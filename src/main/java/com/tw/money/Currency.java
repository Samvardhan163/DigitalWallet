package com.tw.money;

public enum Currency {
    rupee(1),
    usDollar(76),
    euro(1 / 0.012);

    private final double baseFactor;

    Currency(double baseFactor) {
        this.baseFactor = baseFactor;
    }

    public double convertToBaseFactor(double value) {
        return value * baseFactor;
    }
}
