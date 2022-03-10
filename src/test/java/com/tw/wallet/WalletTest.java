package com.tw.wallet;

import com.tw.money.Rupee;
import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTest {

    @Test
    public void shouldAdd15RupeesInWallet() throws InvalidValueException {
        Wallet wallet = new Wallet();
        Rupee rupee = new Rupee(15);
        wallet.add(rupee);
        Rupee actual = wallet.balance();
        assertThat(actual, is(equalTo(rupee)));
    }


}
