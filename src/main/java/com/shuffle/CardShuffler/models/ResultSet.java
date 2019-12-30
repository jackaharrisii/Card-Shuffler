package com.shuffle.CardShuffler.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class ResultSet {

    @Id
    private Long trackedCardStartPosition;
    private ArrayList<Bins> resultsAfterMultipleShuffles;

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
}
