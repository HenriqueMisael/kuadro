package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import com.henriquemisael.kuadro.service.component.CardTypeSaver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class UpdateCardTypeServiceTest extends UnitTest {

    @Mock
    private CardTypeRepository cardTypeRepository;
    @Mock
    private CardTypeSaver cardTypeSaver;
    @Mock
    private CardType cardType;
    private UpdateCardTypeService subject;

    @Before
    public void before() {
        subject = new UpdateCardTypeService(cardTypeRepository, cardTypeSaver);
    }

    @Test
    public void update() {
        doReturn(Optional.of(cardType)).when(cardTypeRepository).findById(1L);

        subject.update(1L, cardType);

        verify(cardType).setId(1L);
        verify(cardTypeSaver).save(cardType);
    }

    @Test
    public void dontUpdateForUnexistentId() {
        doReturn(Optional.empty()).when(cardTypeRepository).findById(1L);

        assertThrows(CardTypeNotFoundException.class, () -> subject.update(1L, cardType));

        verify(cardTypeRepository).findById(1L);
        verifyNoMoreInteractions(cardType);
        verifyNoMoreInteractions(cardTypeRepository);
        verifyNoMoreInteractions(cardTypeSaver);
    }
}