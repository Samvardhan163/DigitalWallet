package com.tw.money;

import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EuroTest {

    @Test
    void shouldNotBeAbleToCreateInvalidEuro() {
        assertThrows(InvalidValueException.class, () -> new Euro(-1));
    }

    @Test
    void shouldAssertPoint012MultipliedWith83PointFourteen3IsEqualTo1() {
        double actual = 0.012 * 83.33333333333333;
        double expected = 1;
        assertThat(actual, is(equalTo(expected)));
    }
}
