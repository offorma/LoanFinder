package com.zopa.loanfinder;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * This class represents the market
 *
 * @author Nonso
 * @version 0.1
 */
public class Market {

    private static LinkedList<Lender> allLenders = new LinkedList<>();

    /**
     * Method to add a Lender to market.
     *
     * @param lend A lender object
     * @return void
     */
    public static void addLender(Lender lend) {
        allLenders.add(lend);
    }

    /**
     * Method to returns All Lenders.
     *
     * @return LinkedList<Lender>
     */
    public static LinkedList<Lender> getAllLenders() {
        return allLenders;
    }

    /**
     * Method set a LinkedList as all Lenders in the market.
     *
     * @param allLenders A LinkedList of lenders
     * @return void
     */
    public static void setAllLenders(LinkedList<Lender> allLenders) {
        Market.allLenders = allLenders;
    }

    /**
     * Method to sort all the lenders in the market according to interate rate.
     *
     * @return LinkedList<Lender>
     */
    public static LinkedList<Lender> sortByPercentage() {
        Market.getAllLenders().sort(Comparator.comparingDouble(Lender::getPercentage));
        return Market.getAllLenders();
    }
}
