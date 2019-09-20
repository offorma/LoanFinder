package com.zopa.loanfinder;



import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LendersTest {
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
        Lenders.setAllLenders(allLenders);
        bus = new Business(new BigInteger("1000"),36,12);
    }

    @Test
    public void testGetAllLenders(){
        assertArrayEquals("", Lenders.getAllLenders().toArray(),allLenders.toArray());
    }

    @Test
    public void testSetLenders(){
        LinkedList<Lender> myLenders = new LinkedList<>();
        myLenders.add(new Lender("Bob", 0.075, "640"));
        Lenders.setAllLenders(myLenders);
        assertArrayEquals("Test the setAllLenders method",myLenders.toArray(),Lenders.getAllLenders().toArray());
    }

    @Test
    public void testSortingLenders(){
        Lenders.setAllLenders(allLenders);
        assertEquals("Test the setAllLenders method",allLenders.toArray()[1],Lenders.sortByPercentage().toArray()[0]);
    }

}
