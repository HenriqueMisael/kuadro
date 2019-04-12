package com.henriquemisael.kuadro.exception.preconditionfailed;

import static com.henriquemisael.kuadro.message.MessageKey.CARD_TYPE_NAME_REQUIRED;

public class CardTypeNameRequiredException extends PreconditionFailedException {

    public CardTypeNameRequiredException() {
        super(CARD_TYPE_NAME_REQUIRED);
    }
}
