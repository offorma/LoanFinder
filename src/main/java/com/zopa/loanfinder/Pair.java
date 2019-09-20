package com.zopa.loanfinder;

import java.math.BigInteger;

public class Pair {

    private double interestRate;
    private BigInteger amount;

    public Pair(double interestRate, BigInteger amount) {
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
        return "com.zopa.loanfinder.Pair{" +
                "interestRate=" + interestRate +
                ", amount=" + amount +
                '}';
    }
}
