package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardTypeService extends DeleteModelAbstractService<CardType> {

    public DeleteCardTypeService(CardTypeRepository repository) {
        super(repository, CardTypeNotFoundException::new);
    }
}
