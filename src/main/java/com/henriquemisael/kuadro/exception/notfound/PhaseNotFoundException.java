package com.henriquemisael.kuadro.exception.notfound;

import com.henriquemisael.kuadro.message.MessageKey;

import javax.validation.constraints.NotNull;

public class PhaseNotFoundException extends NotFoundException {

    public PhaseNotFoundException(@NotNull Long id) {
        super(MessageKey.PHASE_NOT_FOUND_FOR_ID, id);
    }
}
