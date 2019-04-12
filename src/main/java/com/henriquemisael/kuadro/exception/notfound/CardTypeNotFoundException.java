package com.henriquemisael.kuadro.exception.notfound;

import com.henriquemisael.kuadro.message.MessageKey;

public class CardTypeNotFoundException extends NotFoundException {

    public CardTypeNotFoundException(long id) {
        super(MessageKey.CARD_TYPE_NOT_FOUND_FOR_ID, id);
    }
}
