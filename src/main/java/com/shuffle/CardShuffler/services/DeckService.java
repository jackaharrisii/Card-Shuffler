package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.Deck;
import com.shuffle.CardShuffler.repositories.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeckService {
    private DeckRepository repository;

    public DeckService(DeckRepository repository) {this.repository = repository;}

    public Deck shuffle(Deck deck){
        ArrayList<String> leftHalf = new ArrayList<>();
        ArrayList<String> rightHalf = new ArrayList<>();
        for(int i = 0; i < deck.getCardset().length; i++){
            if (i < deck.getCardset().length/2) leftHalf.add(deck.getCardset()[i]);
            else rightHalf.add(deck.getCardset()[i]);
        }
        return deck;
    }

}
