package com.henriquemisael.kuadro.exception.preconditionfailed;

import static com.henriquemisael.kuadro.message.MessageKey.CARD_TYPE_INITIAL_STATE_REQUIRED;

public class CardTypeInitialStateRequiredException extends PreconditionFailedException {

    public CardTypeInitialStateRequiredException() {
        super(CARD_TYPE_INITIAL_STATE_REQUIRED);
    }
}
