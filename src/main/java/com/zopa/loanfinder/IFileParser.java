package com.zopa.loanfinder;

import java.io.IOException;

public interface IFileParser {

    void parseCsv(String str) throws IOException;
}
