package com.henriquemisael.kuadro.service.component;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.preconditionfailed.PhaseNameRequiredException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class PhaseSaverTest extends UnitTest {

    @Mock
    private PhaseRepository phaseRepository;
    @Mock
    private NameNotBlankChecker nameNotBlankChecker;
    private PhaseSaver subject;

    @Before
    public void before() {
        subject = new PhaseSaver(phaseRepository, nameNotBlankChecker);
    }

    @Test
    public void save() {
        Phase phaseSaved = testSupport.getPhase("On budget");
        phaseSaved.setId(1L);
        Phase phase = testSupport.getPhase("On budget");
        doReturn(phaseSaved).when(phaseRepository).save(phase);

        Phase returned = subject.save(phase);

        verify(phaseRepository).save(phase);
        verify(nameNotBlankChecker).check(eq(phase), ArgumentMatchers.<Supplier<PhaseNameRequiredException>>any());
        assertNotNull(returned);
        assertEquals(phaseSaved, returned);
    }

    @Test
    public void dontSaveWithoutName() {
        Phase phase = new Phase();
        doThrow(PhaseNameRequiredException.class).when(nameNotBlankChecker).check(eq(phase), ArgumentMatchers.<Supplier<PhaseNameRequiredException>>any());

        assertThrows(PhaseNameRequiredException.class, () -> subject.save(phase));
    }
}