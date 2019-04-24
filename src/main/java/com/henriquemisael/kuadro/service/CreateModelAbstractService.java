package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.exception.badrequest.CreateServiceShouldNotBeUsedForUpdate;
import com.henriquemisael.kuadro.model.entity.AbstractModel;
import com.henriquemisael.kuadro.service.component.ModelAbstractSaver;

import java.util.function.Function;

public abstract class CreateModelAbstractService<T extends AbstractModel> {

    private final ModelAbstractSaver<T> saver;
    private Function<Long, ? extends CreateServiceShouldNotBeUsedForUpdate> exceptionSupplier;

    protected CreateModelAbstractService(ModelAbstractSaver<T> saver, Function<Long, ? extends CreateServiceShouldNotBeUsedForUpdate> exceptionSupplier) {
        this.saver = saver;
        this.exceptionSupplier = exceptionSupplier;
    }

    public T create(T cardType) {

        if (cardType.getId() != null) {
            throw exceptionSupplier.apply(cardType.getId());
        }

        return saver.save(cardType);
    }
}
