package com.henriquemisael.kuadro.service.component;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeNameRequiredException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class CardTypeSaverTest extends UnitTest {

    @Mock
    private CardTypeRepository cardTypeRepository;
    private CardTypeSaver subject;

    @Before
    public void before() {
        subject = new CardTypeSaver();
    }

    @Test
    public void save() {
        CardType cardTypeSaved = testSupport.getCardType("Demand", "On budget");
        cardTypeSaved.setId(1L);
        CardType cardType = testSupport.getCardType("Demand", "On budget");
        doReturn(cardTypeSaved).when(cardTypeRepository).save(cardType);

        CardType returned = subject.save(cardType);

        verify(cardTypeRepository).save(cardType);
        assertNotNull(returned);
        assertEquals(cardTypeSaved, returned);
    }

    @Test
    public void dontSaveWithoutName() {
        assertThrows(CardTypeNameRequiredException.class, () -> subject.save(testSupport.getCardType(null, "On budget")));
    }

    @Test
    public void dontSaveWithoutInitialPhase() {
        assertThrows(CardTypeNameRequiredException.class, () -> subject.save(testSupport.getCardType("Demand", null)));
    }
}