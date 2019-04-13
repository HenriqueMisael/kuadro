package com.henriquemisael.kuadro.exception.badrequest;

import com.henriquemisael.kuadro.controller.CardTypeController;

public class CreateCardTypeServiceShouldNotBeUsedForUpdate extends CreateServiceShouldNotBeUsedForUpdate {

    protected CreateCardTypeServiceShouldNotBeUsedForUpdate(Long id) {
        super(CardTypeController.PATH, id);
    }
}
