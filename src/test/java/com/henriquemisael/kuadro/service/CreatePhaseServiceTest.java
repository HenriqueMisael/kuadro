package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.badrequest.CreatePhaseServiceShouldNotBeUsedForUpdate;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.service.component.PhaseSaver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class CreatePhaseServiceTest extends UnitTest {

    @Mock
    private PhaseSaver phaseSaver;
    private CreatePhaseService subject;

    @Before
    public void before() {
        subject = new CreatePhaseService(phaseSaver);
    }

    @Test
    public void create() {
        Phase phaseSaved = testSupport.getPhase("On budget");
        phaseSaved.setId(1L);
        Phase phase = testSupport.getPhase("On budget");

        doReturn(phaseSaved).when(phaseSaver).save(phase);

        Phase returned = subject.create(phase);

        verify(phaseSaver).save(phase);
        assertNotNull(returned);
        assertEquals(phaseSaved, returned);
    }

    @Test
    public void dontCreateWithGivenId() {
        assertThrows(CreatePhaseServiceShouldNotBeUsedForUpdate.class, () -> {
            Phase phase = testSupport.getPhase("On budget");
            phase.setId(1L);

            subject.create(phase);
        });
    }
}