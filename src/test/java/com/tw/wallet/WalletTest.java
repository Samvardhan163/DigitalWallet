package com.tw.wallet;

import com.tw.money.Money;
import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static com.tw.money.Money.newRupee;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTest {

    @Test
    public void shouldAdd15RupeesInWallet() throws InvalidValueException {
        Wallet wallet = new Wallet();
        Money rupee = newRupee(15);
        wallet.add(rupee);
        Money actual = wallet.balance();
        assertThat(actual, is(equalTo(rupee)));
    }


}
