package com.shuffle.CardShuffler.repositories;

import com.shuffle.CardShuffler.models.Deck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
}
