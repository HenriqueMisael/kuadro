package com.henriquemisael.kuadro.service.component;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ModelAbstractSaver<T> {

    private JpaRepository<T, Long> repository;

    protected ModelAbstractSaver(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T save(T cardType) {

        validate(cardType);

        return repository.save(cardType);
    }

    protected abstract void validate(T cardType);
}
