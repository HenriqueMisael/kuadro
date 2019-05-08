package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.badrequest.CreatePhaseServiceShouldNotBeUsedForUpdate;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.service.component.PhaseSaver;
import org.springframework.stereotype.Service;

@Service
public class CreatePhaseService extends CreateModelAbstractService<Phase> {

    public CreatePhaseService(PhaseSaver saver) {
        super(saver, CreatePhaseServiceShouldNotBeUsedForUpdate::new);
    }
}
