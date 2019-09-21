package com.zopa.loanfinder;

import java.io.IOException;

/**
 * This Inteface allows for adding new file reading capabilities
 * @author Nonso
 * @version 0.1
 */
public interface IFileParser {

    void parseCsv(String str) throws IOException;
}
