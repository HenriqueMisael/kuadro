package com.henriquemisael.kuadro.controller;

import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.service.FindAllCardsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CardTypeController.PATH)
public class CardTypeController {

    static final String PATH = "/api/card-type";
    private FindAllCardsService findAllCardsService;

    public CardTypeController(FindAllCardsService findAllCardsService) {
        this.findAllCardsService = findAllCardsService;
    }

    @GetMapping
    public List<CardType> findAll() {
        return findAllCardsService.find();
    }
}
