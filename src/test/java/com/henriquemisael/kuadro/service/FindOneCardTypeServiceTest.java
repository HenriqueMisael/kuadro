package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class FindOneCardTypeServiceTest extends UnitTest {

    @Mock
    private CardTypeRepository cardTypeRepository;
    private FindOneCardTypeService subject;

    @Before
    public void before() {
        subject = new FindOneCardTypeService(cardTypeRepository);
    }

    @Test
    public void notFound() {
        doReturn(Optional.empty()).when(cardTypeRepository).findById(1L);

        assertThrows(CardTypeNotFoundException.class, () -> subject.find(1L));
    }

    @Test
    public void found() {
        CardType cardType = testSupport.getCardType("Demand", "On budget");
        doReturn(Optional.of(cardType)).when(cardTypeRepository).findById(1L);

        assertEquals(cardType, subject.find(1L));
    }
}