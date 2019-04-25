package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class DeleteCardTypeServiceTest extends UnitTest {

    @Mock
    private CardTypeRepository cardTypeRepository;
    @Mock
    private CardType cardType;
    private DeleteCardTypeService subject;

    @Before
    public void before() {
        subject = new DeleteCardTypeService(cardTypeRepository);
    }

    @Test
    public void update() {
        doReturn(Optional.of(cardType)).when(cardTypeRepository).findById(1L);

        subject.delete(1L);

        verify(cardTypeRepository).delete(cardType);
    }

    @Test
    public void dontUpdateForUnexistentId() {
        doReturn(Optional.empty()).when(cardTypeRepository).findById(1L);

        assertThrows(CardTypeNotFoundException.class, () -> subject.delete(1L));

        verify(cardTypeRepository).findById(1L);
        verifyNoMoreInteractions(cardTypeRepository);
    }
}