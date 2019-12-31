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
    public void shuffleReturnsAFullDeckOf52Cards() {
        deckService.shuffle(testDeck);
        Assert.assertEquals(52, testDeck.getCardset().size());
    }

    @Test
    public void shuffledDeckContainsASamplingOfTheOriginalCards(){
        deckService.shuffle(testDeck);
        Assert.assertTrue(testDeck.getCardset().contains("2c"));
        Assert.assertTrue(testDeck.getCardset().contains("Ad"));
        Assert.assertTrue(testDeck.getCardset().contains("10h"));
        Assert.assertTrue(testDeck.getCardset().contains("Qs"));
    }

    @Test
    public void shuffledDeckNotInTheOriginalOrder(){
        ArrayList<String> unexpected = testDeck.getCardset();
        deckService.shuffle(testDeck);
        Assert.assertNotEquals(unexpected, testDeck.getCardset());
    }

    @Test
    public void splitDeckIntoTwoHalvesTest() {
        ArrayList<String> expectedLeftHalf = new ArrayList<String>(Arrays.asList("2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad"));
        ArrayList<String> expectedRightHalf = new ArrayList<String>(Arrays.asList("2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As"));
        deckService.splitDeckIntoTwoHalves(testDeck);
        Assert.assertEquals(expectedLeftHalf, deckService.getLeftHalf());
        Assert.assertEquals(expectedRightHalf, deckService.getRightHalf());
    }

    @Test
    public void mergeTwoHalvesTest() {
        deckService.splitDeckIntoTwoHalves(testDeck);
        deckService.mergeTwoHalves();
        Assert.assertEquals(52,deckService.getShuffledDeck().size());
        Assert.assertTrue(deckService.getShuffledDeck().contains("2c"));
        Assert.assertTrue(deckService.getShuffledDeck().contains("9d"));
        Assert.assertTrue(deckService.getShuffledDeck().contains("Jh"));
        Assert.assertTrue(deckService.getShuffledDeck().contains("As"));
    }

    @Test
    public void addLeftToDeckTest() {
        deckService.splitDeckIntoTwoHalves(testDeck);
        deckService.addLeftToDeck();
        //check whether 1st card was added to shuffled deck
        Assert.assertEquals("2c",deckService.getShuffledDeck().get(0));
        //check whether 1st card was removed from left half
        Assert.assertEquals("3c",deckService.getLeftHalf().get(0));
    }

    @Test
    public void addRightToDeckTest() {
        deckService.splitDeckIntoTwoHalves(testDeck);
        deckService.addRightToDeck();
        //check whether 1st card was added to shuffled deck
        Assert.assertEquals("2h",deckService.getShuffledDeck().get(0));
        //check whether 1st card was removed from left half
        Assert.assertEquals("3h",deckService.getRightHalf().get(0));    }

    @Test
    public void leftCardFallsIfRightHalfIsEmpty() {
        deckService.splitDeckIntoTwoHalves(testDeck);
        deckService.getRightHalf().clear();
        Assert.assertTrue(deckService.doesLeftCardFallFirst());
    }

    @Test
    public void rightCardFallsIfLeftHalfIsEmpty() {
        deckService.splitDeckIntoTwoHalves(testDeck);
        deckService.getLeftHalf().clear();
        Assert.assertFalse(deckService.doesLeftCardFallFirst());
    }

    @Test
    public void randomCardFallsIfNeitherHalfIsEmpty() {
        deckService.splitDeckIntoTwoHalves(testDeck);
        Assert.assertNotNull(deckService.doesLeftCardFallFirst());
    }

    @Test
    public void resetDeckTest() {
        testDeck.setCardset(new ArrayList<String>(Arrays.asList("one","two")));
        deckService.resetDeck(testDeck);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad",
                "2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As"));
        Assert.assertEquals(expected,testDeck.getCardset());
    }

    @Test
    public void getLeftHalfTest() {
        ArrayList<String> expectedLeftHalf = new ArrayList<String>(Arrays.asList("2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad"));
        deckService.splitDeckIntoTwoHalves(testDeck);
        Assert.assertEquals(expectedLeftHalf,deckService.getLeftHalf());
    }

    @Test
    public void getRightHalfTest() {
        ArrayList<String> expectedRightHalf = new ArrayList<String>(Arrays.asList("2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As"));
        deckService.splitDeckIntoTwoHalves(testDeck);
        Assert.assertEquals(expectedRightHalf,deckService.getRightHalf());
    }

}
