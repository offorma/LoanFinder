package com.zopa.loanfinder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class does all the business logic invloved in calculating loan Amortization.
 *
 * @author Nonso
 * @version 0.1
 */
public class Business {
    private final BigInteger amount;
    private final int numberOfMonthInAYear;
    private final int tenourInMonths;
    private Quote quote = new Quote();

    /**
     * Creates an Business object with the specified parameters.
     *
     * @param amount               The amount to be borrowed and is off datatype BigInterger.
     * @param tenourInMonths       The duration of the loan tenure in months.
     * @param numberOfMonthInAYear A constant for the number of months in a year.
     */
    public Business(BigInteger amount, int tenourInMonths, int numberOfMonthInAYear) {
        this.amount = amount;
        this.tenourInMonths = tenourInMonths;
        this.numberOfMonthInAYear = numberOfMonthInAYear;
    }

    private List<Loan> findPossibleLenders() {
        List<Loan> loans = new ArrayList<>();
        quote.setRequestedAmount(this.amount);
        BigInteger totalAmount = this.amount;
        if (totalAmount.equals(BigInteger.ZERO)) {
            return Collections.emptyList();
        }
        if (!this.pollHasFunds()) {
            Messages.displayInsufficentPollFunds();
            return Collections.emptyList();
        }
        Market.sortByPercentage();
        while (totalAmount.compareTo(BigInteger.ZERO) != 0) {
            Lender lender = Market.getAllLenders().poll();
            if (lender.getAmount().compareTo(totalAmount) <= 0) {
                loans.add(new Loan(lender.getPercentage(), lender.getAmount()));
                totalAmount = totalAmount.subtract(lender.getAmount());
                if (totalAmount.equals(BigInteger.ZERO)) break;
            } else if (lender.getAmount().compareTo(totalAmount) == 1) {
                loans.add(new Loan(lender.getPercentage(), totalAmount));
                break;
            }
        }
        return loans;
    }

    private double getMonthlyInterestRate() {
        List<Loan> loans = this.findPossibleLenders();
        double interest = loans.stream().mapToDouble(loan -> loan.getInterestRate()).average()
                .orElseThrow(() -> new ArithmeticException("Unable to calculate average interest rate"));
        this.quote.setAnnualInterest(interest);
        return interest / numberOfMonthInAYear;
    }

    private double calculateAmortizationFactor() {
        double monthlyRate = getMonthlyInterestRate();
        return (monthlyRate * Math.pow((1 + monthlyRate), tenourInMonths)) / (Math.pow((1 + monthlyRate), tenourInMonths) - 1);
    }

    private BigDecimal monthlyPayment() {
        BigDecimal calculated = new BigDecimal(this.amount).multiply(new BigDecimal(this.calculateAmortizationFactor()));
        quote.setMonthlyRepayment(calculated);
        return calculated;
    }

    private boolean validateAmount() {
        return (this.amount.compareTo(new BigInteger("1000")) != -1 || this.amount.compareTo(new BigInteger("15000")) < 1)
                && this.amount.remainder(new BigInteger("100")).equals(BigInteger.ZERO);
    }

    private boolean pollHasFunds() {
        return Market.getAllLenders().stream().mapToInt(lender -> lender.getAmount().intValue()).sum() >= this.amount.intValue();
    }

    /**
     * Calculates total money to be repaid and returns it as BigDecimal.
     */
    public BigDecimal totalAmountDue() {
        BigDecimal calculated;
        if (!validateAmount()) {
            throw (new IllegalArgumentException("amount must be a multiple of hundred and between 1000 and 15000 inclusive"));
        }
        calculated = this.monthlyPayment().multiply(new BigDecimal(tenourInMonths));
        quote.setTotalrepayment(calculated);
        return calculated;
    }

    /**
     * Returns a quote object
     */
    public Quote getQuote() {
        return quote;
    }
}
