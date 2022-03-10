package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WalletTest {

    Wallet wallet = new Wallet();

    @Test
    public void shouldAdd15RupeesInWallet(){
        int expected = wallet.amount() + 15;
        wallet.addAmount(15);
        int result = wallet.amount();
        assertThat(result, is(expected));
    }
}
