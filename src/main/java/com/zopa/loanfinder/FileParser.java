package com.zopa.loanfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class reads the content of a csv file
 * @author Nonso
 * @version 0.1
 */
public class FileParser implements IFileParser {
    private static final Logger log = LoggerFactory.getLogger(FileParser.class);

    /**
     * Creates an Business object with the specified parameters.
     *
     * @param csvFile string representing file path
     * @throws IOException           throws an IOException if file path is invalid.
     * @throws NumberFormatException throws a NumberFormatException percentage and amount are not valid strings.
     */
    public void parse(final String csvFile) throws IOException, NumberFormatException {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count != 0) { // this makes sure i skip the first line which is the headers
                    String[] lender = line.split(",");
                    double percentage = Double.parseDouble(lender[1]);
                    Lender lend = new Lender(lender[0], percentage, lender[2]);
                    Market.addLender(lend);
                }
                count++;
            }
        }

    }
}
