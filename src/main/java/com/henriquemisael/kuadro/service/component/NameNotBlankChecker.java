package com.henriquemisael.kuadro.service.component;

import com.henriquemisael.kuadro.exception.preconditionfailed.PreconditionFailedException;
import com.henriquemisael.kuadro.model.entity.NamedModel;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.function.Supplier;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Component
public class NameNotBlankChecker {

    <E extends PreconditionFailedException> void check(@NotNull NamedModel model, Supplier<? extends E> exceptionSupplier) throws E {
        if (isBlank(model.getName())) {
            throw exceptionSupplier.get();
        }
    }
}
