package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.notfound.PhaseNotFoundException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import com.henriquemisael.kuadro.service.component.PhaseSaver;
import org.springframework.stereotype.Service;

@Service
public class UpdatePhaseService extends UpdateModelAbstractService<Phase> {

    public UpdatePhaseService(PhaseRepository repository, PhaseSaver saver) {
        super(repository, saver, PhaseNotFoundException::new);
    }
}
