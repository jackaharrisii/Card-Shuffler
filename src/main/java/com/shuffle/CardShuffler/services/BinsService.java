package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.models.Bins;
import org.springframework.stereotype.Service;

@Service
public class BinsService {



    public void incrementBucketAt(Bins bin, Integer index){
        bin.getBuckets()[index]++;
    }

    public void resetBin(Bins bin){
        for (int i = 0; i < bin.getBuckets().length; i++){
            bin.getBuckets()[i] = 0;
        }
    }

}
