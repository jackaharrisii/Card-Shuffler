package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.Deck;
import com.shuffle.CardShuffler.repositories.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class DeckService {
    private DeckRepository repository;

    ArrayList<String> leftHalf = new ArrayList<>();
    ArrayList<String> rightHalf = new ArrayList<>();

    public DeckService(DeckRepository repository) {this.repository = repository;}

    public Deck shuffle(Deck deck){
        splitDeckIntoTwoHalves(deck);
        ArrayList shuffledDeck = mergeTwoHalves(leftHalf, rightHalf);

        //STILL WORKING ON THIS

        return null;
    }

    public void splitDeckIntoTwoHalves (Deck deck){
        for(int i = 0; i < deck.getCardset().length; i++){
            if (i < deck.getCardset().length/2) leftHalf.add(deck.getCardset()[i]);
            else rightHalf.add(deck.getCardset()[i]);
        }
    }

    public ArrayList mergeTwoHalves(ArrayList leftHalf, ArrayList rightHalf){
        Random random = new Random();
        Boolean leftCardFallsFirst;
        ArrayList shuffledDeck = new ArrayList();
        for (int i = 0; i < 52; i++){
            // extract this to a method when cleaning code
            if (leftHalf.get(0) == null) leftCardFallsFirst = false;
            else if(rightHalf.get(0) == null) leftCardFallsFirst = true;
            else leftCardFallsFirst = random.nextBoolean();
            // extract each of these to methods also
            if (leftCardFallsFirst == true) {
                shuffledDeck.add(leftHalf.get(0));
                leftHalf.remove(0);
            }
            else {
                shuffledDeck.add(rightHalf.get(0));
                rightHalf.remove(0);
            }
        }
        return shuffledDeck;
    }

    // use these when cleaning the above code
    public void addLeftToDeck(){}
    public void addRightToDeck(){}
    public void determineWhichCardFallsFirst(){}

}
