package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.notfound.NotFoundException;
import com.henriquemisael.kuadro.model.entity.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Function;

public abstract class DeleteModelAbstractService<T extends AbstractModel> {

    private final JpaRepository<T, Long> repository;
    private final Function<Long, ? extends NotFoundException> exceptionSupplier;

    public DeleteModelAbstractService(JpaRepository<T, Long> repository, Function<Long, ? extends NotFoundException> exceptionSupplier) {
        this.repository = repository;
        this.exceptionSupplier = exceptionSupplier;
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> exceptionSupplier.apply(id)));
    }
}
