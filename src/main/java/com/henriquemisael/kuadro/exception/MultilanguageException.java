package com.henriquemisael.kuadro.exception;

import com.henriquemisael.kuadro.message.MessageKey;

public class MultilanguageException extends RuntimeException {

    private final MessageKey messageKey;
    private final Object[] args;

    protected MultilanguageException(MessageKey messageKey, Object... args) {
        this.messageKey = messageKey;
        this.args = args;
    }

    public MessageKey getMessageKey() {
        return messageKey;
    }

    public Object[] getArgs() {
        return args;
    }
}
