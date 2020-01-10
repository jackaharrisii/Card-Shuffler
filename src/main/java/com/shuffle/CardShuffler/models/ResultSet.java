package com.shuffle.CardShuffler.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class ResultSet {

    @Id
    private Long trackedCardStartPosition;
    // create a unique result set for each card in the starting deck, tracked by the above id
    // each result set contains an ArrayList of bins
    // a bin is all the possible positions that starting card ended up in after a given number of shuffles
    // the index within the ArrayList denotes the number of shuffles
    // e.g., after 1000 initial shuffles, the bin at index=0 will probably have a pattern
    //       after 1000 7th shuffles, the bin at index=6 will likely be fairly evenly distributed
    private String trackedCard = generateResultSetName(trackedCardStartPosition);
    private ArrayList<Bins> resultsAfterMultipleShuffles;

    public ResultSet (){}

    public ResultSet (Long trackedCardStartPosition, ArrayList<Bins> resultsAfterMultipleShuffles){
        this.trackedCardStartPosition = trackedCardStartPosition;
        this.resultsAfterMultipleShuffles = resultsAfterMultipleShuffles;
    }

    public Long getTrackedCardStartPosition() {
        return trackedCardStartPosition;
    }

    public void setTrackedCardStartPosition(Long trackedCardStartPosition) {
        this.trackedCardStartPosition = trackedCardStartPosition;
    }

    public ArrayList<Bins> getResultsAfterMultipleShuffles() {
        return resultsAfterMultipleShuffles;
    }

    public void setResultsAfterMultipleShuffles(ArrayList<Bins> resultsAfterMultipleShuffles) {
        this.resultsAfterMultipleShuffles = resultsAfterMultipleShuffles;
    }

    public String generateResultSetName(Long id){
        Deck starterDeck = new Deck();
        return starterDeck.getCardset().get(id.intValue());
    }

}
