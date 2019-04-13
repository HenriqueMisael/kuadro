package com.henriquemisael.kuadro.exception.badrequest;

import com.henriquemisael.kuadro.exception.MultilanguageException;
import com.henriquemisael.kuadro.message.MessageKey;

public class BadRequestException extends MultilanguageException {

    protected BadRequestException(MessageKey messageKey, Object... args) {
        super(messageKey, args);
    }
}
