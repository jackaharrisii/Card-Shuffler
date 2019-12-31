package com.shuffle.CardShuffler.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DeckTest {

    Deck testDeck;

    @Before
    public void setUp() throws Exception {
        testDeck = new Deck();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCardset() {
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad",
                "2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As"));
        Assert.assertEquals(expected, testDeck.getCardset());
    }

    @Test
    public void setCardset() {
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("one","two","test","true"));
        testDeck.setCardset(expected);
        Assert.assertEquals(expected,testDeck.getCardset());
    }
}
