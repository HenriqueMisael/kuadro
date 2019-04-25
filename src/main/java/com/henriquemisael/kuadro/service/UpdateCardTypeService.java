package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import com.henriquemisael.kuadro.service.component.CardTypeSaver;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardTypeService extends UpdateModelAbstractService<CardType> {

    public UpdateCardTypeService(CardTypeRepository repository, CardTypeSaver saver) {
        super(repository, saver, CardTypeNotFoundException::new);
    }
}
