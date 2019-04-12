package com.henriquemisael.kuadro.message;

import com.henriquemisael.kuadro.exception.MultilanguageException;
import org.springframework.core.env.Environment;

import java.util.HashMap;

class AbstractLanguage implements Language {

    private final HashMap<MessageKey, String> messages;

    public AbstractLanguage(Environment environment) {
        messages = new HashMap<>();
        for (MessageKey messageKey : MessageKey.values()) {
            messages.put(messageKey, environment.getProperty(messageKey.toString()));
        }
    }

    @Override
    public String get(MessageKey messageKey, Object... args) {
        return messageKey.get(messages.get(messageKey), args);
    }

    @Override
    public String get(MultilanguageException exception) {
        return get(exception.getMessageKey(), exception.getArgs());
    }
}
