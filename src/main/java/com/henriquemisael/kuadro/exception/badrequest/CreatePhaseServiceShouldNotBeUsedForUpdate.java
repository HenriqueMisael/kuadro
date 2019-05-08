package com.henriquemisael.kuadro.exception.badrequest;

import com.henriquemisael.kuadro.controller.PhaseController;

public class CreatePhaseServiceShouldNotBeUsedForUpdate extends CreateServiceShouldNotBeUsedForUpdate {

    public CreatePhaseServiceShouldNotBeUsedForUpdate(Long id) {
        super(PhaseController.PATH, id);
    }
}
