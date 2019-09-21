package com.zopa.loanfinder;

import java.math.BigInteger;

/**
 * This class represents a instace of a lender in the market
 *
 * @author Nonso
 * @version 0.1
 */
public class Lender {

    private String name;
    private double percentage;
    private String amount;

    public Lender() {
    }

    /**
     * Public constructor for lender.
     *
     * @param name       Name of lender.
     * @param percentage Yearly Percentage interest wanted in returns .
     * @param amount     Amount willing to be lent.
     */
    public Lender(String name, double percentage, String amount) {
        this.name = name;
        this.percentage = percentage;
        this.amount = amount;
    }

    /**
     * Method to returns percentage.
     *
     * @return double
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * Method to returns amount.
     *
     * @return BigInteger
     */
    public BigInteger getAmount() {
        return new BigInteger(this.amount);
    }

    /**
     * Method to print object.
     *
     * @return String        object in string format.
     */
    @Override
    public String toString() {
        return "com.zopa.loanfinder.Lender{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                ", amount=" + amount +
                '}';
    }
}
