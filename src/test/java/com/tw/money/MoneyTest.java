package com.tw.money;

import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static com.tw.money.Money.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    void shouldNotBeAbleToCreateNegativeRupee() {
        assertThrows(InvalidValueException.class, () -> createRupee(-1));
    }

    @Test
    void shouldNotBeAbleToCreateNegativeUSDollar() {
        assertThrows(InvalidValueException.class, () -> createUsDollar(-1));
    }

    @Test
    void shouldNotBeAbleToCreateNegativeEuro() {
        assertThrows(InvalidValueException.class, () -> createEuro(-1));
    }

    @Test
    public void shouldAssertAddingThreeRupeeAndSevenRupeeIsEqualToTenRupee() throws InvalidValueException {
        Money threeRupee = createRupee(3);
        Money sevenRupee = createRupee(7);
        Money tenRupee = createRupee(10);

        Money sumOfSevenAndThreeRupees = threeRupee.add(sevenRupee);

        assertThat(sumOfSevenAndThreeRupees, is(equalTo(tenRupee)));
    }

    @Test
    public void shouldAssertATenRupeeIsNotSameAnotherTenRupee() throws InvalidValueException {
        Money tenRupee = createRupee(10);
        Money anotherTenRupee = createRupee(10);

        assertNotSame(tenRupee, anotherTenRupee);
    }

    @Test
    public void shouldAssertValueOfATenRupeeIsSameAsValueOfAnotherTenRupee() throws InvalidValueException {
        Money tenRupee = createRupee(10);
        Money anotherTenRupee = createRupee(10);

        assertEquals(tenRupee, anotherTenRupee);
    }

    @Test
    void shouldAssertTenRupeeIsNotEqualToNull() throws InvalidValueException {
        Money tenRupee = createRupee(10);

        assertNotEquals(null, tenRupee);
    }

    @Test
    void shouldAssertTenRupeeIsNotEqualToAWallet() throws InvalidValueException {
        Money tenRupee = createRupee(10);

        assertNotEquals(tenRupee, new Object());
    }


    @Test
    void shouldAssertThatSeventySixRupeeIsEqualToOneUSDollar() throws InvalidValueException {
        Money seventySixRupee = createRupee(76);
        Money oneUSDollar = createUsDollar(1);

        assertThat(seventySixRupee, is(equalTo(oneUSDollar)));
    }

    @Test
    void shouldAssertThatOneRupeeIsEqualToZeroPointZeroOneTwoEuro() throws InvalidValueException {
        Money oneRupee = createRupee(1);
        Money pointZeroOneTwoEuro = createEuro(0.012);

        assertThat(oneRupee, is(equalTo(pointZeroOneTwoEuro)));
    }
}
