package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.Bins;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class BinsServiceTest {

    BinsService binsService = new BinsService();
    Bins testBin;

    @Before
    public void setUp() throws Exception {
        testBin = new Bins();
    }

    @After
    public void tearDown() throws Exception {
        binsService.resetBin(testBin);
    }

    @Test
    public void incrementBucketTest() {
        binsService.incrementBucketAt(testBin, 0);
        Integer expected = 1;
        Assert.assertEquals(expected, testBin.getBuckets()[0]);
    }

    @Test
    public void resetBin() {
        binsService.incrementBucketAt(testBin,0);
        binsService.resetBin(testBin);
        Integer expected = 0;
        Assert.assertEquals(expected,testBin.getBuckets()[0]);
    }
}
