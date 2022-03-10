package com.tw.money;

import exceptions.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RupeeTest {

    @Test
    public void shouldNotAbleToCreateRupeeIfValueIsInvalid(){
        assertThrows(InvalidValueException.class, () -> new Rupee(-1));
    }

    @Test
    public void shouldReturnNew10RupeeIf3RupeeAnd7RupeeIsAdded() throws InvalidValueException {
        Rupee rupee1 = new Rupee(3);
        Rupee rupee2 = new Rupee(7);
        Rupee result = rupee1.add(rupee2);
        Rupee expected = new Rupee(10);
        assertThat(result.value(), is(equalTo(expected.value())));
    }

    @Test
    public void shouldAssertA10RupeeIsNotSameAsOther10Rupee() throws InvalidValueException {
        Rupee tenRupee = new Rupee(10);
        Rupee anotherTenRupee = new Rupee(10);
        assertThat(tenRupee.equals(anotherTenRupee), is(false));
    }

    @Test
    public void shouldAssertValueOfA10RupeeIsSameAsValueOfAnother10Rupee() throws InvalidValueException {
        Rupee tenRupee = new Rupee(10);
        Rupee anotherTenRupee = new Rupee(10);
        assertThat(tenRupee.value(), is(equalTo(anotherTenRupee.value())));
    }
}
