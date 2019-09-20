package com.zopa.loanfinder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Quote {

    private BigInteger requestedAmount;
    private String annualInterest; //X.X%
    private BigDecimal monthlyRepayment; // £XXXX.XX
    private BigDecimal totalrepayment; // : £XXXX.XX

    public Quote() {
    }

    public Quote(BigInteger requestedAmount, String annualInterest, BigDecimal monthlyRepayment, BigDecimal totalrepayment) {
        this.requestedAmount = requestedAmount;
        this.annualInterest = annualInterest; //
        this.monthlyRepayment = monthlyRepayment;
        this.totalrepayment = totalrepayment;
    }

    public BigInteger getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(BigInteger requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    private String getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(Double annualInterest) {
        String formated = String.format("%.1f", annualInterest * 100);
        this.annualInterest = formated + "%";
    }

    private BigDecimal getMonthlyRepayment() {
        return monthlyRepayment.setScale(2, RoundingMode.CEILING);
    }

    public void setMonthlyRepayment(BigDecimal monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    private BigDecimal getTotalrepayment() {
        return totalrepayment.setScale(2, RoundingMode.CEILING);
    }

    public void setTotalrepayment(BigDecimal totalrepayment) {
        this.totalrepayment = totalrepayment;
    }

    @Override
    public String toString() {
        return "com.zopa.loanfinder.Quote{" +
                "requestedAmount=" + requestedAmount +
                ", annualInterest=" + getAnnualInterest() +
                ", monthlyRepayment=" + getMonthlyRepayment() +
                ", totalrepayment=" + getTotalrepayment() +
                '}';
    }
}
