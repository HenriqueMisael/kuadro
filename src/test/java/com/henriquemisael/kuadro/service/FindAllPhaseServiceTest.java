package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
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

public class FindAllPhaseServiceTest extends UnitTest {

    @Mock
    private PhaseRepository phaseRepository;
    private FindAllPhaseService subject;

    @Before
    public void before() {
        subject = new FindAllPhaseService(phaseRepository);
    }

    @Test
    public void findNone() {
        doReturn(emptyList()).when(phaseRepository).findAll();

        List<Phase> phases = subject.find();

        assertNotNull(phases);
        assertEquals(0, phases.size());
    }

    @Test
    public void findOne() {
        Phase phase = new Phase();
        doReturn(singletonList(phase)).when(phaseRepository).findAll();

        List<Phase> phases = subject.find();

        assertNotNull(phases);
        assertEquals(1, phases.size());
        assertEquals(phase, phases.get(0));
    }

    @Test
    public void findMany() {
        Phase firstPhase = testSupport.getPhase("On Budget");
        Phase secondPhase = testSupport.getPhase("On Development");
        doReturn(asList(firstPhase, secondPhase)).when(phaseRepository).findAll();

        List<Phase> phases = subject.find();

        assertNotNull(phases);
        assertEquals(2, phases.size());
        assertEquals(firstPhase, phases.get(0));
        assertEquals(secondPhase, phases.get(1));
    }
}