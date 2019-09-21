package com.zopa.loanfinder;
/**
 * A helper class to print messages
 * @author Nonso
 * @version 0.1
 */
public class Messages {


    public static void displayInsufficentPollFunds(){
        System.out.println("Market has insufficeint funds");
    }

    public static void displayQuote(Business b){
        System.out.printf("this is the best qoute wee can offer %s%n", b.getQuote());
    }
}
