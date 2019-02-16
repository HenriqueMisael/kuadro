package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class FindAllCardsService extends FindAllAbstractService<CardType> {

    public FindAllCardsService(CardTypeRepository repository) {
        super(repository);
    }
}
