package com.henriquemisael.kuadro.message;

public interface Language {

    String get(MessageKey messageKey, Object... args);
}
