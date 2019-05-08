package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import org.springframework.stereotype.Service;

@Service
public class FindAllPhaseService extends FindAllAbstractService<Phase> {

    public FindAllPhaseService(PhaseRepository repository) {
        super(repository);
    }
}
