package com.henriquemisael.kuadro.controller;

import com.henriquemisael.kuadro.exception.notfound.PhaseNotFoundException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(PhaseController.PATH)
public class PhaseController implements Controller {

    public static final String PATH = "/api/phase";
    private final FindAllPhaseService findAllPhaseService;
    private final FindOnePhaseService findOnePhaseService;
    private final CreatePhaseService createPhaseService;
    private final UpdatePhaseService updatePhaseService;
    private final DeletePhaseService deletePhaseService;

    public PhaseController(FindAllPhaseService findAllPhaseService, FindOnePhaseService findOnePhaseService, CreatePhaseService createPhaseService, UpdatePhaseService updatePhaseService, DeletePhaseService deletePhaseService) {
        this.findAllPhaseService = findAllPhaseService;
        this.findOnePhaseService = findOnePhaseService;
        this.createPhaseService = createPhaseService;
        this.updatePhaseService = updatePhaseService;
        this.deletePhaseService = deletePhaseService;
    }

    @GetMapping
    public ResponseEntity<List<Phase>> findAll() {
        return ResponseEntity.ok(findAllPhaseService.find());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phase> findOne(@PathVariable Long id) throws PhaseNotFoundException {
        return ResponseEntity.ok(findOnePhaseService.find(id));
    }

    @PostMapping
    public ResponseEntity<Phase> create(@RequestBody Phase phase) {

        phase = createPhaseService.create(phase);

        return ResponseEntity.created(URI.create(PATH + "/" + phase.getId())).body(phase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phase> update(@PathVariable @NotNull Long id, @RequestBody Phase phase) {

        phase = updatePhaseService.update(id, phase);

        return ResponseEntity.ok(phase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull Long id) {

        deletePhaseService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
