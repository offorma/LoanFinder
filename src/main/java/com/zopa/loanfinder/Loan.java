package com.zopa.loanfinder;

import java.math.BigInteger;
/**
 * This class represents the valid loans from the market
 * @author Nonso
 * @version 0.1
 */
public class Loan {

    private double interestRate;
    private BigInteger amount;

    public Loan(double interestRate, BigInteger amount) {
        this.interestRate = interestRate;
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "com.zopa.loanfinder.Loan{" +
                "interestRate=" + interestRate +
                ", amount=" + amount +
                '}';
    }
}
