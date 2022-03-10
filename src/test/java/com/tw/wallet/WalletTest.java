package com.tw.wallet;

import com.tw.money.Rupee;
import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    Wallet wallet = new Wallet();

    public WalletTest() throws InvalidValueException {
    }

    @Test
    public void shouldAdd15RupeesInWallet() throws InvalidValueException {
        Rupee rupee = new Rupee(15);
        float expected = wallet.balance().value() + rupee.value();
        wallet.add(rupee);
        float result = wallet.balance().value();
        assertThat(result, is(equalTo(expected)));
    }


}
