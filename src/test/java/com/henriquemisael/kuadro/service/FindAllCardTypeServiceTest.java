package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.repository.CardTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

public class FindAllCardTypeServiceTest extends UnitTest {

    @Mock
    private CardTypeRepository cardTypeRepository;
    private FindAllCardTypeService subject;

    @Before
    public void before() {
        subject = new FindAllCardTypeService(cardTypeRepository);
    }

    @Test
    public void findNone() {
        doReturn(emptyList()).when(cardTypeRepository).findAll();

        List<CardType> cardTypes = subject.find();

        assertNotNull(cardTypes);
        assertEquals(0, cardTypes.size());
    }

    @Test
    public void findOne() {
        CardType cardType = new CardType();
        doReturn(singletonList(cardType)).when(cardTypeRepository).findAll();

        List<CardType> cardTypes = subject.find();

        assertNotNull(cardTypes);
        assertEquals(1, cardTypes.size());
        assertEquals(cardType, cardTypes.get(0));
    }

    @Test
    public void findMany() {
        CardType firstCardType = testSupport.getCardType("Demand", "On Budget");
        CardType secondCardType = testSupport.getCardType("Service Order", "On Development");
        doReturn(asList(firstCardType, secondCardType)).when(cardTypeRepository).findAll();

        List<CardType> cardTypes = subject.find();

        assertNotNull(cardTypes);
        assertEquals(2, cardTypes.size());
        assertEquals(firstCardType, cardTypes.get(0));
        assertEquals(secondCardType, cardTypes.get(1));
    }
}