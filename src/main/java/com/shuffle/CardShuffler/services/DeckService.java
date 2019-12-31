package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Service
public class DeckService {

    private ArrayList<String> leftHalf = new ArrayList<>();
    private ArrayList<String> rightHalf = new ArrayList<>();
    private ArrayList<String> shuffledDeck = new ArrayList<>();

    public Deck shuffle(@Autowired Deck deck){
        splitDeckIntoTwoHalves(deck);
        mergeTwoHalves();
        deck.setCardset(getShuffledDeck());
        return deck;
    }

    public void splitDeckIntoTwoHalves (@Autowired Deck deck){
        for(int i = 0; i < deck.getCardset().size(); i++){
            if (i < deck.getCardset().size()/2) leftHalf.add(deck.getCardset().get(i));
            else rightHalf.add(deck.getCardset().get(i));
        }
    }

    public void mergeTwoHalves(){
        Boolean leftCardFallsFirst;
        for (int i = 0; i < 52; i++){
            leftCardFallsFirst = doesLeftCardFallFirst();
            if (leftCardFallsFirst == true) {
                addLeftToDeck();
            }
            else {
                addRightToDeck();
            }
        }
    }

    // use these when cleaning the above code
    public void addLeftToDeck(){
        getShuffledDeck().add(getLeftHalf().get(0));
        getLeftHalf().remove(0);
    }

    public void addRightToDeck(){
        getShuffledDeck().add(getRightHalf().get(0));
        getRightHalf().remove(0);
    }

    public Boolean doesLeftCardFallFirst(){
        if (getLeftHalf().size() == 0) return false;
        else if(getRightHalf().size() == 0) return true;
        else {
            Random random = new Random();
            return random.nextBoolean();
        }
    }

    public void resetDeck(Deck deck){
        deck.setCardset(new ArrayList<String>(Arrays.asList("2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ac","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ad",
                "2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ah","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","As")));
    }

    public ArrayList<String> getLeftHalf() {
        return leftHalf;
    }

    public ArrayList<String> getRightHalf() {
        return rightHalf;
    }

    public void setLeftHalf(ArrayList<String> leftHalf) {
        this.leftHalf = leftHalf;
    }

    public void setRightHalf(ArrayList<String> rightHalf) {
        this.rightHalf = rightHalf;
    }

    public ArrayList<String> getShuffledDeck() {
        return shuffledDeck;
    }

    public void setShuffledDeck(ArrayList<String> shuffledDeck) {
        this.shuffledDeck = shuffledDeck;
    }
}
