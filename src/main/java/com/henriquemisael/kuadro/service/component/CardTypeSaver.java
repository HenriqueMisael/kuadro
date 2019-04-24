package com.henriquemisael.kuadro.service.component;

import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeInitialStateRequiredException;
import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeNameRequiredException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.springframework.stereotype.Component;

@Component
public class CardTypeSaver extends ModelAbstractSaver<CardType> {

    private NameNotBlankChecker nameNotBlankChecker;

    public CardTypeSaver(CardTypeRepository cardTypeRepository, NameNotBlankChecker nameNotBlankChecker) {
        super(cardTypeRepository);
        this.nameNotBlankChecker = nameNotBlankChecker;
    }

    @Override
    protected void validate(CardType cardType) {
        nameNotBlankChecker.check(cardType, CardTypeNameRequiredException::new);

        if (cardType.getInitialState() == null) {
            throw new CardTypeInitialStateRequiredException();
        }
    }
}
