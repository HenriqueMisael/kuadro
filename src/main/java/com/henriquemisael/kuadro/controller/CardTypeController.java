package com.henriquemisael.kuadro.controller;

import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.service.CreateCardTypeService;
import com.henriquemisael.kuadro.service.FindAllCardTypeService;
import com.henriquemisael.kuadro.service.FindOneCardTypeService;
import com.henriquemisael.kuadro.service.UpdateCardTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(CardTypeController.PATH)
public class CardTypeController {

    public static final String PATH = "/api/card-type";
    private final FindAllCardTypeService findAllCardTypeService;
    private final FindOneCardTypeService findOneCardTypeService;
    private final CreateCardTypeService createCardTypeService;
    private final UpdateCardTypeService updateCardTypeService;

    public CardTypeController(FindAllCardTypeService findAllCardTypeService, FindOneCardTypeService findOneCardTypeService, CreateCardTypeService createCardTypeService, UpdateCardTypeService updateCardTypeService) {
        this.findAllCardTypeService = findAllCardTypeService;
        this.findOneCardTypeService = findOneCardTypeService;
        this.createCardTypeService = createCardTypeService;
        this.updateCardTypeService = updateCardTypeService;
    }

    @GetMapping
    public ResponseEntity<List<CardType>> findAll() {
        return ResponseEntity.ok(findAllCardTypeService.find());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardType> findOne(@PathVariable Long id) throws CardTypeNotFoundException {
        return ResponseEntity.ok(findOneCardTypeService.find(id));
    }

    @PostMapping
    public ResponseEntity<CardType> create(@RequestBody CardType cardType) {

        cardType = createCardTypeService.create(cardType);

        return ResponseEntity.created(URI.create(PATH + "/" + cardType.getId())).body(cardType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardType> update(@PathVariable @NotNull Long id, @RequestBody CardType cardType) {

        cardType = updateCardTypeService.update(id, cardType);

        return ResponseEntity.ok(cardType);
    }
}
