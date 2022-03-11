package com.tw.money;

import com.tw.wallet.Wallet;
import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static com.tw.money.Money.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void shouldNotBeAbleToCreateInvalidRupee() {
        assertThrows(InvalidValueException.class, () -> newRupee(-1));
    }

    @Test
    void shouldNotBeAbleToCreateInvalidUSDollar() {
        assertThrows(InvalidValueException.class, () -> newUSDollar(-1));
    }

    @Test
    void shouldNotBeAbleToCreateInvalidEuro() {
        assertThrows(InvalidValueException.class, () -> newEuro(-1));
    }

    @Test
    public void shouldAssertAdding3RupeeAnd7RupeeIsEqualTo10Rupee() throws InvalidValueException {
        Money threeRupee = newRupee(3);
        Money sevenRupee = newRupee(7);
        Money tenRupee = newRupee(10);

        Money sumOfSevenAndThreeRupees = threeRupee.add(sevenRupee);

        assertThat(sumOfSevenAndThreeRupees, is(equalTo(tenRupee)));
    }

    @Test
    public void shouldAssertA10RupeeIsNotSameAsOther10Rupee() throws InvalidValueException {
        Money tenRupee = newRupee(10);
        Money anotherTenRupee = newRupee(10);

        assertNotSame(tenRupee, anotherTenRupee);
    }

    @Test
    public void shouldAssertValueOfA10RupeeIsSameAsValueOfAnother10Rupee() throws InvalidValueException {
        Money tenRupee = newRupee(10);
        Money anotherTenRupee = newRupee(10);

        assertEquals(tenRupee, anotherTenRupee);
    }

    @Test
    void shouldAssert10RupeeIsNotEqualToNull() throws InvalidValueException {
        Money tenRupee = newRupee(10);

        assertNotEquals(null,tenRupee);
    }

    @Test
    void shouldAssert10RupeeIsNotEqualToAWallet() throws InvalidValueException {
        Money tenRupee = newRupee(10);
        Wallet wallet = new Wallet();

        assertNotEquals(wallet, tenRupee);
    }


    @Test
    void shouldAssertThat76RupeeIsEqualTo1USDollar() throws InvalidValueException {
        Money seventySixRupee = newRupee(76);
        Money oneUSDollar = newUSDollar(1);

        assertThat(seventySixRupee, is(equalTo(oneUSDollar)));
    }

    @Test
    void shouldAssertThat1RupeeIsEqualTo0Point012Euro() throws InvalidValueException {
        Money oneRupee = newRupee(1);
        Money pointZeroOneTwoEuro = newEuro(0.012);

        assertThat(oneRupee, is(equalTo(pointZeroOneTwoEuro)));
    }
}
