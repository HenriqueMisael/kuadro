package com.henriquemisael.kuadro.service.component;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeNameRequiredException;
import com.henriquemisael.kuadro.exception.preconditionfailed.PreconditionFailedException;
import com.henriquemisael.kuadro.model.entity.NamedModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.function.Supplier;

import static org.mockito.Mockito.*;

public class NameNotBlankCheckerTest extends UnitTest {

    @Mock
    private NamedModel model;
    @Mock
    private Supplier<? extends PreconditionFailedException> exceptionSupplier;
    private NameNotBlankChecker subject;

    @Before
    public void before() {
        subject = new NameNotBlankChecker();
    }

    @Test
    public void nameNotNull() {
        doReturn("Name").when(model).getName();

        subject.check(model, exceptionSupplier);

        verify(model).getName();
        verifyNoMoreInteractions(model);
    }

    @Test
    public void nameNull() {
        doReturn(null).when(model).getName();

        assertThrows(CardTypeNameRequiredException.class, () -> subject.check(model, CardTypeNameRequiredException::new));

        verify(model).getName();
        verifyNoMoreInteractions(model);
    }
}