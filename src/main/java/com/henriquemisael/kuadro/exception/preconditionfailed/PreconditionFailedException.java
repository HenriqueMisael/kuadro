package com.henriquemisael.kuadro.exception.preconditionfailed;

import com.henriquemisael.kuadro.exception.MultilanguageException;
import com.henriquemisael.kuadro.message.MessageKey;

public class PreconditionFailedException extends MultilanguageException {

    protected PreconditionFailedException(MessageKey messageKey, Object... args) {
        super(messageKey, args);
    }
}
