package com.zopa.loanfinder;

import java.math.BigInteger;

/**
 * This class represents the valid loans from the market
 *
 * @author Nonso
 * @version 0.1
 */
public class Loan {

    private double interestRate;
    private BigInteger amount;

    /**
     * Public constructor for lender.
     *
     * @param interestRate Yearly Percentage interest wanted in returns .
     * @param amount       Amount to be lent.
     */
    public Loan(double interestRate, BigInteger amount) {
        this.interestRate = interestRate;
        this.amount = amount;
    }

    /**
     * Method to returns interestRate.
     *
     * @return double
     */
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "com.zopa.loanfinder.Loan{" +
                "interestRate=" + interestRate +
                ", amount=" + amount +
                '}';
    }
}
