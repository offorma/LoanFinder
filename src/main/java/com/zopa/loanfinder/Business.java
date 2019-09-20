package com.zopa.loanfinder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class does all the business logic invloved in calculating loan Amortization
 */
public class Business {
    private final BigInteger amount;
    private final int numberOfMonthInAYear;
    private final int tenourInMonths;
    private Quote quote = new Quote();

    public Business(BigInteger amount, int tenourInMonths, int numberOfMonthInAYear) {
        this.amount = amount;
        this.tenourInMonths = tenourInMonths;
        this.numberOfMonthInAYear = numberOfMonthInAYear;
    }

    private List<Pair> findPossibleLenders() {
        List<Pair> pair = new ArrayList<>();
        quote.setRequestedAmount(this.amount);
        BigInteger totalAmount = this.amount;
        if (totalAmount.equals(BigInteger.ZERO)) {
            return Collections.emptyList();
        }
        if (!this.pollHasFunds()) {
            Messages.displayInsufficentPollFunds();
            return Collections.emptyList();
        }
        Lenders.sortByPercentage();
        while (totalAmount.compareTo(BigInteger.ZERO) != 0) {
            Lender lender = Lenders.getAllLenders().poll();
            if (lender.getAmount().compareTo(totalAmount) <= 0) {
                pair.add(new Pair(lender.getPercentage(), lender.getAmount()));
                totalAmount = totalAmount.subtract(lender.getAmount());
                if (totalAmount.equals(BigInteger.ZERO)) break;
            } else if (lender.getAmount().compareTo(totalAmount) == 1) {
                pair.add(new Pair(lender.getPercentage(), totalAmount));
                break;
            }
        }
        return pair;
    }

    private double getMonthlyInterestRate() {
        List<Pair> pairs = this.findPossibleLenders();

        double interest = pairs.stream().mapToDouble(pair ->pair.getInterestRate()).average()
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
       return (this.amount.compareTo(new BigInteger("1000")) != -1 || this.amount.compareTo(new BigInteger("15000")) < 1 )
                && this.amount.remainder(new BigInteger("100")).equals(BigInteger.ZERO);
    }

    private boolean pollHasFunds() {
        return Lenders.getAllLenders().stream().mapToInt(lender -> lender.getAmount().intValue()).sum() >= this.amount.intValue();
    }

    public BigDecimal totalAmountDue() {
        BigDecimal calculated;
        if (!validateAmount()) {
            throw (new IllegalArgumentException("amount must be a multiple of hundred and between 1000 and 15000 inclusive"));
        }
        calculated = this.monthlyPayment().multiply(new BigDecimal(tenourInMonths));
        quote.setTotalrepayment(calculated);
        return calculated;
    }

    public Quote getQuote() {
        return quote;
    }
}
