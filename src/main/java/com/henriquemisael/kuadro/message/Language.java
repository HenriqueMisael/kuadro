package com.henriquemisael.kuadro.message;

import com.henriquemisael.kuadro.exception.MultilanguageException;

public interface Language {

    String get(MessageKey messageKey, Object... args);

    String get(MultilanguageException exception);
}
