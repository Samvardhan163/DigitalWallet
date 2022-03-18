package com.tw.wallet;

import com.tw.money.Currency;
import com.tw.money.Money;
import exceptions.InvalidValueException;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static com.tw.money.Money.*;
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

    @Test
    void shouldAddOneRupeeAndOneDollarInTheWalletAndToTakeTenRupeeFromTheWallet() throws InvalidValueException {
        Wallet wallet = new Wallet();
        Money oneRupee = createRupee(1);
        Money oneDollar = createUsDollar(1);
        Money tenRupee = createRupee(10);
        Money sixtySeven = createRupee(67);
        wallet.add(oneRupee);
        wallet.add(oneDollar);

        wallet.take(tenRupee);

        assertEquals(sixtySeven, wallet.balance());
    }

    @Test
    void shouldAddFiftyRupeeAndOneDollarInTheWalletAndToTakeMoneyInTheUsDollar() throws InvalidValueException {
        Wallet wallet = new Wallet();
        Money fiftyRupee = createRupee(50);
        Money oneDollar = createUsDollar(1);
        Money hundredSevenEight = createRupee(178);
        Money fourDollar = createUsDollar(4);
        wallet.add(fiftyRupee);
        wallet.add(oneDollar);
        wallet.add(hundredSevenEight);

        wallet.convertIntoPreferredCurrency(Currency.usDollar);

        assertEquals(fourDollar, wallet.balance());
    }

    @Test
    void shouldAddOneEuroAndOneDollarInTheWalletAndToTakeInTheEuro() throws InvalidValueException {
        Wallet wallet = new Wallet();
        Money oneEuro = createEuro(1);
        Money oneDollar = createUsDollar(1);
        Money onePointNineOneTwoEuro = createEuro(1.91);
        wallet.add(oneEuro);
        wallet.add(oneDollar);

        wallet.convertIntoPreferredCurrency(Currency.euro);

        assertEquals(onePointNineOneTwoEuro, wallet.balance());
    }

}
