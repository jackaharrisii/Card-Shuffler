package com.shuffle.CardShuffler.controllers;

import com.shuffle.CardShuffler.services.ResultSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ResultSetController {
    private ResultSetService resultSetService;

    @Autowired

    public ResultSetController(ResultSetService resultSetService) {
        this.resultSetService = resultSetService;
    }

}
