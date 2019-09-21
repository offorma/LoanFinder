package com.zopa.loanfinder;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class BusinessTest {
    private LinkedList<Lender> allLenders;
    private Business validBus;
    private Business invalidBus;

    @Before
    public void getMeReady(){
        allLenders = new LinkedList<>();
        allLenders.add(new Lender("Bob", 0.075, "640"));
        allLenders.add(new Lender("Jane", 0.069, "480"));
        allLenders.add(new Lender("Fred", 0.071, "520"));
        allLenders.add(new Lender("Mary", 0.104, "170"));
        allLenders.add(new Lender("John", 0.081, "320"));
        allLenders.add(new Lender("Dave", 0.074, "140"));
        allLenders.add(new Lender("Angela", 0.071, "60"));
        validBus = new Business(new BigInteger("1000"),36,12);
        invalidBus = new Business(new BigInteger("1050"),36,12);
        Quote quote = new Quote();
        quote.setAnnualInterest(7.0);
        quote.setMonthlyRepayment(new BigDecimal("30.88"));
        quote.setTotalrepayment(new BigDecimal("1111.58"));
        quote.setRequestedAmount(new BigInteger("1000"));
    }

    @Test
    public void TestTotalAmountDue(){
        Market.setAllLenders(allLenders);
        assertEquals("Assert that total Amount is correct","1111.58", validBus.totalAmountDue().setScale(2, RoundingMode.CEILING).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestTotalAmountDueError(){
        invalidBus.totalAmountDue();

    }
    @Test
    public void TestGetQuote(){
        invalidBus.totalAmountDue();

    }
}
