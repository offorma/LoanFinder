package com.zopa.loanfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class Lender {

    private String name;
    private double percentage;
    private String amount;

    private Logger log = LoggerFactory.getLogger(Lender.class);

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
        BigInteger number = BigInteger.ZERO;
        try {
           number = new BigInteger(this.amount);
        }catch (NumberFormatException e){
            log.error("Could not convert String ammount into BigInterger", e);
        }
        return number;
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
