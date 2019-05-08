package com.henriquemisael.kuadro;

import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import org.springframework.stereotype.Component;

import static com.google.common.collect.Sets.newHashSet;
import static org.apache.logging.log4j.util.Strings.isBlank;

@Component
public class TestSupport {

    private PhaseRepository phaseRepository;
    private CardTypeRepository cardTypeRepository;

    public TestSupport(PhaseRepository phaseRepository, CardTypeRepository cardTypeRepository) {
        this.phaseRepository = phaseRepository;
        this.cardTypeRepository = cardTypeRepository;
    }

    void deleteAll() {
        cardTypeRepository.deleteAll();
        phaseRepository.deleteAll();
    }

    public Phase insertAndGetPhase(String phaseName) {
        return phaseRepository.save(getPhase(phaseName));
    }

    public Phase getPhase(String phaseName) {
        return new Phase(phaseName);
    }

    public CardType getCardType(String name, String initialPhaseName) {

        Phase initialPhase;
        if (isBlank(initialPhaseName)) {
            initialPhase = null;
        } else {
            initialPhase = getPhase(initialPhaseName);
        }

        return new CardType(name, initialPhase);
    }
}
