package com.henriquemisael.kuadro.controller;

import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.service.FindAllCardTypeService;
import com.henriquemisael.kuadro.service.FindOneCardTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CardTypeController.PATH)
public class CardTypeController {

    static final String PATH = "/api/card-type";
    private final FindAllCardTypeService findAllCardTypeService;
    private final FindOneCardTypeService findOneCardTypeService;

    public CardTypeController(FindAllCardTypeService findAllCardTypeService, FindOneCardTypeService findOneCardTypeService) {
        this.findAllCardTypeService = findAllCardTypeService;
        this.findOneCardTypeService = findOneCardTypeService;
    }

    @GetMapping
    public ResponseEntity<List<CardType>> findAll() {
        return ResponseEntity.ok(findAllCardTypeService.find());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardType> findOne(@PathVariable Long id) throws CardTypeNotFoundException {
        return ResponseEntity.ok(findOneCardTypeService.find(id));
    }
}
