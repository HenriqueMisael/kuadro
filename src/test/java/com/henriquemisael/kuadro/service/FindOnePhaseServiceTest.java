package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.notfound.PhaseNotFoundException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class FindOnePhaseServiceTest extends UnitTest {

    @Mock
    private PhaseRepository phaseRepository;
    private FindOnePhaseService subject;

    @Before
    public void before() {
        subject = new FindOnePhaseService(phaseRepository);
    }

    @Test
    public void notFound() {
        doReturn(Optional.empty()).when(phaseRepository).findById(1L);

        assertThrows(PhaseNotFoundException.class, () -> subject.find(1L));
    }

    @Test
    public void found() {
        Phase phase = testSupport.getPhase("On budget");
        doReturn(Optional.of(phase)).when(phaseRepository).findById(1L);

        assertEquals(phase, subject.find(1L));
    }
}