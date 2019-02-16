package com.henriquemisael.kuadro.message;

public enum MessageKey {
    CARD_TYPE_NOT_FOUND_FOR_ID;

    public String get(String template, Object... args) {

        for (int i = 0; i < args.length; i++) {
            template = template.replace("{" + i + "}", args[i].toString());
        }

        return template;
    }
}
