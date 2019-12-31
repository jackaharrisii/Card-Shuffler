package com.shuffle.CardShuffler.models;

public class Bins {

    private Integer[] buckets;

    public Bins() {
        this.buckets = new Integer[52];
        for (int i = 0; i < buckets.length; i++) this.buckets[i] = 0;
    }

    public Integer[] getBuckets() {
        return buckets;
    }

    public void setBuckets(Integer[] buckets) {
        this.buckets = buckets;
    }

}
