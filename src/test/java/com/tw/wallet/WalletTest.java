package com.tw.wallet;

import com.tw.money.Money;
import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static com.tw.money.Money.createRupee;
import static com.tw.money.Money.createUsDollar;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {

    @Test
    public void shouldAdd15RupeesInWallet() throws InvalidValueException {
        Wallet wallet = new Wallet();
        Money rupee = createRupee(15);
        wallet.add(rupee);
        Money actual = wallet.balance();
        assertThat(actual, is(equalTo(rupee)));
    }

    @Test
    void shouldAddOneDollarAndTwoRupeeInTheWallet() throws InvalidValueException {
        Wallet wallet = new Wallet();
        Money twoRupee = createRupee(2);
        Money oneDollar = createUsDollar(1);
        Money seventyEight = createRupee(78);

        wallet.add(twoRupee);
        wallet.add(oneDollar);

        assertEquals(seventyEight, wallet.balance());
    }
}
