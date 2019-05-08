package com.henriquemisael.kuadro.service.component;

import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeNameRequiredException;
import com.henriquemisael.kuadro.exception.preconditionfailed.PhaseNameRequiredException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PhaseSaver extends ModelAbstractSaver<Phase> {

    private NameNotBlankChecker nameNotBlankChecker;

    protected PhaseSaver(PhaseRepository repository, NameNotBlankChecker nameNotBlankChecker) {
        super(repository);
        this.nameNotBlankChecker = nameNotBlankChecker;
    }

    @Override
    protected void validate(Phase cardType) {
        nameNotBlankChecker.check(cardType, PhaseNameRequiredException::new);
    }
}
