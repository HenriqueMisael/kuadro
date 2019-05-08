package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.notfound.PhaseNotFoundException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePhaseService extends DeleteModelAbstractService<Phase> {

    public DeletePhaseService(PhaseRepository repository) {
        super(repository, PhaseNotFoundException::new);
    }
}
