package com.henriquemisael.kuadro.message;

public enum MessageKey {
    CARD_TYPE_NOT_FOUND_FOR_ID, CARD_TYPE_NAME_REQUIRED, CARD_TYPE_INITIAL_STATE_REQUIRED, PHASE_NAMED_NOT_FOUND_EXCEPTION, CREATE_SERVICE_SHOULD_NOT_BE_USED_FOR_UPDATE;

    public String get(String template, Object... args) {

        for (int i = 0; i < args.length; i++) {
            template = template.replace("{" + i + "}", args[i].toString());
        }

        return template;
    }
}
