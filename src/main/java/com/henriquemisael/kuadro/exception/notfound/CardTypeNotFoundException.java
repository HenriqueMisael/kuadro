package com.henriquemisael.kuadro.exception.notfound;

import com.henriquemisael.kuadro.message.MessageKey;

import javax.validation.constraints.NotNull;

public class CardTypeNotFoundException extends NotFoundException {

    public CardTypeNotFoundException(@NotNull Long id) {
        super(MessageKey.CARD_TYPE_NOT_FOUND_FOR_ID, id);
    }
}
