package com.tw.money;

import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class USDTest {

    @Test
    void shouldNotBeAbleToCreateInvalidUSD() throws InvalidValueException {
        assertThrows(InvalidValueException.class, () -> new USD(-1));
    }

}
