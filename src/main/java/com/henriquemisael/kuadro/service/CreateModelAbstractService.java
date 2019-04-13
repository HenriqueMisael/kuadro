package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.model.entity.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CreateModelAbstractService<T> {

    private final JpaRepository<T, Long> repository;

    protected CreateModelAbstractService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public CardType create(CardType cardType) {

    }
}
