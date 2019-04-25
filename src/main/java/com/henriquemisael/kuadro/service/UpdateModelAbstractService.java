package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.notfound.NotFoundException;
import com.henriquemisael.kuadro.model.entity.AbstractModel;
import com.henriquemisael.kuadro.service.component.ModelAbstractSaver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Function;

public abstract class UpdateModelAbstractService<T extends AbstractModel> {

    private final JpaRepository<T, Long> repository;
    private final ModelAbstractSaver<T> saver;
    private final Function<Long, ? extends NotFoundException> exceptionSupplier;

    public UpdateModelAbstractService(JpaRepository<T, Long> repository, ModelAbstractSaver<T> saver, Function<Long, ? extends NotFoundException> exceptionSupplier) {
        this.repository = repository;
        this.saver = saver;
        this.exceptionSupplier = exceptionSupplier;
    }

    public T update(Long id, T model) {

        if (!repository.findById(id).isPresent()) {
            throw exceptionSupplier.apply(id);
        }

        model.setId(id);
        return saver.save(model);
    }
}
