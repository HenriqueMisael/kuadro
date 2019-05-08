package com.henriquemisael.kuadro.exception.preconditionfailed;

import static com.henriquemisael.kuadro.message.MessageKey.PHASE_NAME_REQUIRED;

public class PhaseNameRequiredException extends PreconditionFailedException {

    public PhaseNameRequiredException() {
        super(PHASE_NAME_REQUIRED);
    }
}
