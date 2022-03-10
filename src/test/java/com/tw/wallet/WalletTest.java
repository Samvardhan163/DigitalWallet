package com.tw.wallet;

import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WalletTest {

    Wallet wallet = new Wallet();

    @Test
    public void shouldAdd15RupeesInWallet() throws InvalidValueException {
        Rupee rupee = new Rupee(15);
        float expected = wallet.balance() + rupee.value();
        wallet.add(rupee.value());
        float result = wallet.balance();
        assertThat(result, is(expected));
    }

}
