package com.henriquemisael.kuadro.exception.notfound;

import com.henriquemisael.kuadro.exception.MultilanguageException;
import com.henriquemisael.kuadro.message.MessageKey;

public class NotFoundException extends MultilanguageException {

    protected NotFoundException(MessageKey messageKey, Object... args) {
        super(messageKey, args);
    }
}
