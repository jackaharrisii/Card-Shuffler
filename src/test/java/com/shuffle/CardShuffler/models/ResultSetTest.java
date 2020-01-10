package com.shuffle.CardShuffler.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Result;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ResultSetTest {

    ResultSet testResultSet;
    ArrayList<Bins> testResultsAfterMultipleShuffles;
    Bins testBin;

    @Before
    public void setUp() throws Exception {
        testResultsAfterMultipleShuffles = new ArrayList<>();
        testBin = new Bins();
        testResultsAfterMultipleShuffles.add(testBin);
        testResultSet = new ResultSet(0l, testResultsAfterMultipleShuffles);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTrackedCardStartPositionTest() {
        Long expected = 0l;
        Assert.assertEquals(expected, testResultSet.getTrackedCardStartPosition());
    }

    @Test
    public void setTrackedCardStartPositionTest() {
        Long expected = 1l;
        testResultSet.setTrackedCardStartPosition(1l);
        Assert.assertEquals(expected, testResultSet.getTrackedCardStartPosition());
    }

    @Test
    public void getResultsAfterMultipleShuffles() {
        Assert.assertEquals(testResultsAfterMultipleShuffles, testResultSet.getResultsAfterMultipleShuffles());
        Assert.assertEquals(testBin, testResultSet.getResultsAfterMultipleShuffles().get(0));
    }

    @Test
    public void setResultsAfterMultipleShuffles() {
        ArrayList<Bins> alternateResults = new ArrayList<>();
        testResultSet.setResultsAfterMultipleShuffles(alternateResults);
        Assert.assertEquals(alternateResults, testResultSet.getResultsAfterMultipleShuffles());
    }

    @Test
    public void turn_id_into_card_name(){
        String expected = "2c";
        Assert.assertEquals(expected, testResultSet.generateResultSetName(0l));
    }

}
