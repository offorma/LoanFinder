package com.zopa.loanfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigInteger;

public class Main {



    public static void main(String[] args) throws IOException {
        String csvFile;
        String loanAmountNeeded;
        Logger log = LoggerFactory.getLogger(Main.class);

        if (args.length != 2) {
            throw new IllegalArgumentException("Application needs two arguments first a csv file and an ammount");
        }
        csvFile = args[0];
        loanAmountNeeded = args[1];
        new FileParser().parse(csvFile);

        Business bus = new Business(new BigInteger(loanAmountNeeded), 36, 12);
        bus.totalAmountDue();
        log.info(bus.getQuote().toString());
    }


}
