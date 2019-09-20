package com.zopa.loanfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser implements  IFileParser{
    private static final Logger log = LoggerFactory.getLogger(FileParser.class);

    public void parseCsv(final String csvFile) throws IOException, NumberFormatException {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            int count = 0;
            while ((line = br.readLine()) != null) { //read each line
                if ( count != 0 ) { // this makes sure i skip the first line which is the headers
                    //this is a potential source of error if file has no header or file has invalid entries
                    String[] lender = line.split(",");
                    double percentage = Double.parseDouble(lender[1]);
                    Lender lend = new Lender(lender[0],percentage, lender[2]);
                    Lenders.addLender(lend);
                }
                count++;
            }
        }

    }
}
