package com.henriquemisael.kuadro.service.component;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeInitialStateRequiredException;
import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeNameRequiredException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class CardTypeSaverTest extends UnitTest {

    @Mock
    private CardTypeRepository cardTypeRepository;
    @Mock
    private NameNotBlankChecker nameNotBlankChecker;
    private CardTypeSaver subject;

    @Before
    public void before() {
        subject = new CardTypeSaver(cardTypeRepository, nameNotBlankChecker);
    }

    @Test
    public void save() {
        CardType cardTypeSaved = testSupport.getCardType("Demand", "On budget");
        cardTypeSaved.setId(1L);
        CardType cardType = testSupport.getCardType("Demand", "On budget");
        doReturn(cardTypeSaved).when(cardTypeRepository).save(cardType);

        CardType returned = subject.save(cardType);

        verify(cardTypeRepository).save(cardType);
        verify(nameNotBlankChecker).check(eq(cardType), ArgumentMatchers.<Supplier<CardTypeNameRequiredException>>any());
        assertNotNull(returned);
        assertEquals(cardTypeSaved, returned);
    }

    @Test
    public void dontSaveWithoutName() {
        CardType cardType = testSupport.getCardType(null, "On budget");
        doThrow(CardTypeNameRequiredException.class).when(nameNotBlankChecker).check(eq(cardType), ArgumentMatchers.<Supplier<CardTypeNameRequiredException>>any());

        assertThrows(CardTypeNameRequiredException.class, () -> subject.save(cardType));
    }

    @Test
    public void dontSaveWithoutInitialPhase() {
        assertThrows(CardTypeInitialStateRequiredException.class, () -> subject.save(testSupport.getCardType("Demand", null)));
    }
}