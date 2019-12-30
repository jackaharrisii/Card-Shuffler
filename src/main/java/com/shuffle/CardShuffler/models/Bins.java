package com.shuffle.CardShuffler.models;

public class Bins {

    Integer[] bins;

    public Bins(Integer[] bins) {
        this.bins = new Integer[52];
    }

    public Integer[] getBins() {
        return bins;
    }

    public void setBins(Integer[] bins) {
        this.bins = bins;
    }
}
