package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.model.entity.CardType;
import org.springframework.stereotype.Service;

@Service
public class CreateCardTypeService extends CreateModelAbstractService<CardType> {

    public CreateCardTypeService() {
        super(repository);
    }
}
