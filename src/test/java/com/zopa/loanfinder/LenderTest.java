package com.zopa.loanfinder;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class LenderTest {
    private Lender invalid;
    private Lender valid;
    @Before
    public void getMeReady(){
        valid = new Lender("Mary", 0.104, "170");
        invalid = new Lender("Mary", 0.104, "##990");
    }

    @Test(expected = NumberFormatException.class)
    public void testGetAmountErr() {
        invalid.getAmount();
    }

    @Test
    public void testGetAmount() {
        assertEquals("",new BigInteger("170"), valid.getAmount());
    }

}
