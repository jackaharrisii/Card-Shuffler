package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.ResultSet;
import com.shuffle.CardShuffler.repositories.ResultSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultSetService {
    private ResultSetRepository resultSetRepository;

    @Autowired
    DeckService deckService;
    @Autowired
    BinsService binsService;

    public ResultSet show(Long id) {
        return resultSetRepository.findById(id).get();
    }

    public ResultSet create(Long id, ResultSet resultSet){
        return resultSetRepository.save(resultSet);
    }



}
