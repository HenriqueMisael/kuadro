package com.henriquemisael.kuadro.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class FindAllAbstractService<T> {

    private JpaRepository<T, Long> repository;

    public FindAllAbstractService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> find() {
        return repository.findAll();
    }
}
