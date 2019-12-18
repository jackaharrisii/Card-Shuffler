package com.shuffle.CardShuffler.controllers;

import com.shuffle.CardShuffler.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeckController {
    private DeckService service;

    @Autowired
    public DeckController(DeckService service) {this.service = service;}



}
