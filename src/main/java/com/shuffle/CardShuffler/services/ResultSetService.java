package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.Bins;
import com.shuffle.CardShuffler.models.Deck;
import com.shuffle.CardShuffler.models.ResultSet;
import com.shuffle.CardShuffler.repositories.ResultSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResultSetService {
    private ResultSetRepository resultSetRepository;

    @Autowired
    DeckService deckService;
    @Autowired
    BinsService binsService;

    public ResultSet generateFullResultSet (){
        return null;
    }

    public ResultSet getFullResultSet(){
        return null;
    }

    public ResultSet showResultsForSingleCard (Long id) {
        return resultSetRepository.findById(id).get();
    }

    public ResultSet generateResultSetForSingleCard(Long id){
        ArrayList<Bins> unnamedBin = new ArrayList<>();
        ResultSet unnamedResultSet = new ResultSet(id, unnamedBin);
        return null;
//        return resultSetRepository.save(resultSet);
    }

}
