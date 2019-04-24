package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.badrequest.CreateCardTypeServiceShouldNotBeUsedForUpdate;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.service.component.CardTypeSaver;
import org.springframework.stereotype.Service;

@Service
public class CreateCardTypeService extends CreateModelAbstractService<CardType> {

    public CreateCardTypeService(CardTypeSaver saver) {
        super(saver, CreateCardTypeServiceShouldNotBeUsedForUpdate::new);
    }
}
