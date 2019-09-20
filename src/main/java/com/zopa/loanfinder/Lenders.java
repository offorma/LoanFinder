package com.zopa.loanfinder;

import java.util.Comparator;
import java.util.LinkedList;

public class Lenders {
    //use queue for lender  Comparator.comparing(com.zopa.loanfinder.Lender::getPercentage).thenComparing(com.zopa.loanfinder.Lender::getAmount)
    private static LinkedList<Lender> allLenders = new LinkedList<>();


    public static void addLender(Lender lend) {
        allLenders.add(lend);
    }

    public static LinkedList<Lender> getAllLenders() {
        return allLenders;
    }

    public static void setAllLenders(LinkedList<Lender> allLenders) {
        Lenders.allLenders = allLenders;
    }

    public static LinkedList<Lender> sortByPercentage() {
        Lenders.getAllLenders().sort(Comparator.comparingDouble(Lender::getPercentage));
        return Lenders.getAllLenders();
    }
}
