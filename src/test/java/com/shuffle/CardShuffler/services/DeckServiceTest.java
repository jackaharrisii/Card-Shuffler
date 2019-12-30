package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.Deck;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

@SpringBootTest
public class DeckServiceTest {

    DeckService deckService = new DeckService();
    Deck testDeck;

    @Before
    public void setUp() throws Exception {
        testDeck = new Deck();
    }

    @After
    public void tearDown() throws Exception {
        deckService.resetDeck(testDeck);
    }

    @Test
    public void shuffleTest() {
        Assert.assertEquals(1,2);
    }

    @Test
    public void splitDeckIntoTwoHalvesTest() {
        ArrayList<String> expectedLeftHalf = new ArrayList<String>(Arrays.asList("1c","2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","1d","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad"));
        ArrayList<String> expectedRightHalf = new ArrayList<String>(Arrays.asList("1h","2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","1s","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As"));
        deckService.splitDeckIntoTwoHalves(testDeck);
        Assert.assertEquals(expectedLeftHalf, deckService.getLeftHalf());
        Assert.assertEquals(expectedRightHalf, deckService.getRightHalf());
    }

    @Test
    public void mergeTwoHalvesTest() {

    }

    @Test
    public void addLeftToDeckTest() {
        Assert.assertEquals(1,2);

    }

    @Test
    public void addRightToDeckTest() {
        Assert.assertEquals(1,2);
    }

    @Test
    public void determineWhichCardFallsFirstTest() {
        Assert.assertEquals(1,2);
    }

    @Test
    public void resetDeckTest() {
        testDeck.setCardset(new String[]{"one","two"});
        deckService.resetDeck(testDeck);
        String[] expected = new String[]{"1c","2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","1d","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad",
                "1h","2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","1s","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As"};
        Assert.assertArrayEquals(expected,testDeck.getCardset());
    }

    @Test
    public void getLeftHalfTest() {
        ArrayList<String> expectedLeftHalf = new ArrayList<String>(Arrays.asList("1c","2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","1d","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad"));
        deckService.splitDeckIntoTwoHalves(testDeck);
        Assert.assertEquals(expectedLeftHalf,deckService.getLeftHalf());
    }

    @Test
    public void getRightHalfTest() {
        ArrayList<String> expectedRightHalf = new ArrayList<String>(Arrays.asList("1h","2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","1s","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As"));
        deckService.splitDeckIntoTwoHalves(testDeck);
        Assert.assertEquals(expectedRightHalf,deckService.getRightHalf());
    }

}
