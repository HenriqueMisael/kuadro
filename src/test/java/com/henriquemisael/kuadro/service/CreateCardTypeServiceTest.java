package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.badrequest.CreateCardTypeServiceShouldNotBeUsedForUpdate;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.service.component.CardTypeSaver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class CreateCardTypeServiceTest extends UnitTest {

    @Mock
    private CardTypeSaver cardTypeSaver;
    private CreateCardTypeService subject;

    @Before
    public void before() {
        subject = new CreateCardTypeService(cardTypeSaver);
    }

    @Test
    public void create() {
        CardType cardTypeSaved = testSupport.getCardType("Demand", "On budget");
        cardTypeSaved.setId(1L);
        CardType cardType = testSupport.getCardType("Demand", "On budget");

        doReturn(cardTypeSaved).when(cardTypeSaver).save(cardType);

        CardType returned = subject.create(cardType);

        verify(cardTypeSaver).save(cardType);
        assertNotNull(returned);
        assertEquals(cardTypeSaved, returned);
    }

    @Test
    public void dontCreateWithGivenId() {
        assertThrows(CreateCardTypeServiceShouldNotBeUsedForUpdate.class, () -> {
            CardType cardType = testSupport.getCardType("Demand", "On budget");
            cardType.setId(1L);

            subject.create(cardType);
        });
    }
}