package com.henriquemisael.kuadro.exception.notfound;

import static com.henriquemisael.kuadro.message.MessageKey.PHASE_NAMED_NOT_FOUND_EXCEPTION;

public class PhaseNamedNotFoundException extends NotFoundException {

    public PhaseNamedNotFoundException(String name) {
        super(PHASE_NAMED_NOT_FOUND_EXCEPTION, name);
    }
}
