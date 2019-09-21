package com.zopa.loanfinder;

import java.util.Comparator;
import java.util.LinkedList;
/**
 * This class represents the market
 * @author Nonso
 * @version 0.1
 */
public class Market {

    private static LinkedList<Lender> allLenders = new LinkedList<>();


    public static void addLender(Lender lend) {
        allLenders.add(lend);
    }

    public static LinkedList<Lender> getAllLenders() {
        return allLenders;
    }

    public static void setAllLenders(LinkedList<Lender> allLenders) {
        Market.allLenders = allLenders;
    }

    public static LinkedList<Lender> sortByPercentage() {
        Market.getAllLenders().sort(Comparator.comparingDouble(Lender::getPercentage));
        return Market.getAllLenders();
    }
}
