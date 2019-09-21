package com.zopa.loanfinder;

import java.math.BigInteger;

/**
 * This class represents a instace of a lender in the market
 * @author Nonso
 * @version 0.1
 */
public class Lender {

    private String name;
    private double percentage;
    private String amount;

    public Lender() {
    }

    public Lender(String name, double percentage, String amount) {
        this.name = name;
        this.percentage = percentage;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public BigInteger getAmount() {
        return new BigInteger(this.amount);
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "com.zopa.loanfinder.Lender{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                ", amount=" + amount +
                '}';
    }
}
