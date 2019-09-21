package com.zopa.loanfinder;

import org.junit.Test;

import java.io.IOException;
import java.util.function.Function;

public class FileParserTest {

    private Function<String, String> func = value -> FileParserTest.class.getClassLoader().getResource(value).getPath();

    @Test(expected = Test.None.class)
    public void testParse() throws IOException {
        new FileParser().parse(func.apply("csv.csv"));
    }

    @Test(expected = NullPointerException.class)
    public void testParseNull() throws IOException {
        new FileParser().parse(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseNumberFormat() throws IOException {
        new FileParser().parse(func.apply("invalidcsv.csv"));
    }


}
