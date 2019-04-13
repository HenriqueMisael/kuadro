package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.notfound.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.function.Function;

public class FindOneAbstractService<T> {

    private final JpaRepository<T, Long> repository;
    private final Function<Long, ? extends NotFoundException> notFoundSupplier;

    public FindOneAbstractService(JpaRepository<T, Long> repository, Function<Long, ? extends NotFoundException> notFoundSupplier) {
        this.repository = repository;
        this.notFoundSupplier = notFoundSupplier;
    }

    public T find(@NotNull Long id) {
        return repository.findById(id).orElseThrow(() -> notFoundSupplier.apply(id));
    }
}
