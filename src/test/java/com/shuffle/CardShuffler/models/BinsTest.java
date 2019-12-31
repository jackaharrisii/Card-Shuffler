package com.shuffle.CardShuffler.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinsTest {

    Bins testBin;

    @Before
    public void setUp() throws Exception {
        testBin = new Bins();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void verifyAllBucketsStartAtZero(){
        Boolean allBucketsAreEmpty = true;
        for (int i = 0; i < 52; i++){
            if (testBin.getBuckets()[i] != 0) allBucketsAreEmpty = false;
        }
        Assert.assertTrue(allBucketsAreEmpty);
    }

    @Test
    public void getBucketsTest() {
        Assert.assertEquals(52, testBin.getBuckets().length);
    }

    @Test
    public void setBucketsTest() {
        testBin.setBuckets(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Assert.assertEquals(expected,testBin.getBuckets());
    }
}
