package com.zopa.loanfinder;

import java.io.IOException;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args)throws IOException {
        String csvFile;
        String loanAmountNeeded;

        if (args.length != 2) {
            throw new IllegalArgumentException("Application needs two arguments first a csv file and an ammount");
        }
            csvFile = args[0];
            loanAmountNeeded = args[1];
            new FileParser().parseCsv(csvFile);

        Business bus = new Business(new BigInteger(loanAmountNeeded), 36, 12);
        bus.totalAmountDue();
        Messages.displayQuote(bus);
    }


}
