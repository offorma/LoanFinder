package com.zopa.loanfinder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * This class represents a quote shown to the customer
 *
 * @author Nonso
 * @version 0.1
 */
public class Quote {

    private BigInteger requestedAmount;
    private String annualInterest; //X.X%
    private BigDecimal monthlyRepayment; // £XXXX.XX
    private BigDecimal totalrepayment; // : £XXXX.XX

    /**
     * A no argument constructor
     */
    public Quote() {
    }

    /**
     * Creates an Business object with the specified parameters.
     *
     * @param requestedAmount  The amount to be borrowed datatype BigInterger.
     * @param annualInterest   Anual interest on the loan datatype String.
     * @param monthlyRepayment Amount to be paid monthly.
     * @param totalrepayment   Total Amount to be paid at the end of the loan tenure.
     */
    public Quote(BigInteger requestedAmount, String annualInterest, BigDecimal monthlyRepayment, BigDecimal totalrepayment) {
        this.requestedAmount = requestedAmount;
        this.annualInterest = annualInterest; //
        this.monthlyRepayment = monthlyRepayment;
        this.totalrepayment = totalrepayment;
    }

    /**
     * Method to return requested amount.
     *
     * @return BigInteger
     */
    public BigInteger getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Method to set requested amount.
     *
     * @return void
     */
    public void setRequestedAmount(BigInteger requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    /**
     * Method to return anual interest.
     *
     * @return String
     */
    private String getAnnualInterest() {
        return annualInterest;
    }

    /**
     * Method to set anual interest.
     *
     * @return void
     */
    public void setAnnualInterest(Double annualInterest) {
        String formated = String.format("%.1f", annualInterest * 100);
        this.annualInterest = formated + "%";
    }

    /**
     * Method to return monthly repayment amount.
     *
     * @return BigDecimal
     */
    private BigDecimal getMonthlyRepayment() {
        return monthlyRepayment.setScale(2, RoundingMode.CEILING);
    }

    /**
     * Method to set monthly payment  amount.
     *
     * @return void
     */
    public void setMonthlyRepayment(BigDecimal monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    /**
     * Method to return total repayment amount.
     *
     * @return BigDecimal
     */
    private BigDecimal getTotalrepayment() {
        return totalrepayment.setScale(2, RoundingMode.CEILING);
    }

    /**
     * Method to set total repayment  amount.
     *
     * @return void
     */
    public void setTotalrepayment(BigDecimal totalrepayment) {
        this.totalrepayment = totalrepayment;
    }

    /**
     * Method to return Quote in string format.
     *
     * @return string
     */
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