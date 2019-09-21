package com.zopa.loanfinder;



import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MarketTest {
    private LinkedList<Lender> allLenders;

    private Business bus;
    @Before
    public void getMeReady(){
        allLenders = new LinkedList<>();
        allLenders.add(new Lender("Bob", 0.075, "640"));
        allLenders.add(new Lender("Jane", 0.069, "480"));
        allLenders.add(new Lender("Fred", 0.071, "520"));
        allLenders.add(new Lender("Mary", 0.104, "170"));
        allLenders.add(new Lender("John", 0.081, "320"));
        allLenders.add(new Lender("Dave", 0.074, "140"));
        allLenders.add(new Lender("Angela", 0.071, "60"));
        Market.setAllLenders(allLenders);
        bus = new Business(new BigInteger("1000"),36,12);
    }

    @Test
    public void testGetAllLenders(){
        assertArrayEquals("", Market.getAllLenders().toArray(),allLenders.toArray());
    }

    @Test
    public void testSetLenders(){
        LinkedList<Lender> myLenders = new LinkedList<>();
        myLenders.add(new Lender("Bob", 0.075, "640"));
        Market.setAllLenders(myLenders);
        assertArrayEquals("Test the setAllLenders method",myLenders.toArray(), Market.getAllLenders().toArray());
    }

    @Test
    public void testSortingLenders(){
        Market.setAllLenders(allLenders);
        assertEquals("Test the setAllLenders method",allLenders.toArray()[1], Market.sortByPercentage().toArray()[0]);
    }

}
