package com.tw.money;

import com.tw.wallet.Wallet;
import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class RupeeTest {

    @Test
    public void shouldNotAbleToCreateRupeeIfValueIsInvalid(){
        assertThrows(InvalidValueException.class, () -> new Rupee(-1));
    }

    @Test
    public void shouldAssertAdding3RupeeAnd7RupeeIsEqualTo10Rupee() throws InvalidValueException {
        Rupee threeRupee = new Rupee(3);
        Rupee sevenRupee = new Rupee(7);
        Rupee tenRupee = new Rupee(10);
        Rupee sumOfSevenAndThreeRupees = threeRupee.add(sevenRupee);
        assertThat(sumOfSevenAndThreeRupees, is(equalTo(tenRupee)));
    }

    @Test
    public void shouldAssertA10RupeeIsNotSameAsOther10Rupee() throws InvalidValueException {
        Rupee tenRupee = new Rupee(10);
        Rupee anotherTenRupee = new Rupee(10);
        assertNotSame(tenRupee, anotherTenRupee);
    }

    @Test
    public void shouldAssertValueOfA10RupeeIsSameAsValueOfAnother10Rupee() throws InvalidValueException {
        Rupee tenRupee = new Rupee(10);
        Rupee anotherTenRupee = new Rupee(10);
        assertEquals(tenRupee, anotherTenRupee);
    }

    @Test
    void shouldAssert10RupeeIsNotEqualToNull() throws InvalidValueException {
        Rupee tenRupee = new Rupee(10);
        assertNotEquals(null,tenRupee);
    }

    @Test
    void shouldAssert10RupeeIsNotEqualToAWallet() throws InvalidValueException {
        Rupee tenRupee = new Rupee(10);
        Wallet wallet = new Wallet();
        assertNotEquals(wallet, tenRupee);
    }

    @Test
    void shouldAssert76RupeeIsEqualTo1USD() throws InvalidValueException {
        Rupee seventySixRupee = new Rupee(76);
        USD oneUSD = new USD(1);
        assertThat(seventySixRupee, is(equalTo(oneUSD)));
        assertThat(oneUSD, is(equalTo(seventySixRupee)));
        // a = b it should always mean b = a

    }

    @Test
    void shouldAssert1RupeeIsEqualTo0Point012() throws InvalidValueException {
        Rupee oneRupee = new Rupee(1);
        Euro pointZeroOneTwoEuro = new Euro(0.012);
        assertThat(oneRupee, is(equalTo(pointZeroOneTwoEuro)));
    }
}
