package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.notfound.PhaseNotFoundException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import com.henriquemisael.kuadro.service.component.PhaseSaver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class UpdatePhaseServiceTest extends UnitTest {

    @Mock
    private PhaseRepository phaseRepository;
    @Mock
    private PhaseSaver phaseSaver;
    @Mock
    private Phase phase;
    private UpdatePhaseService subject;

    @Before
    public void before() {
        subject = new UpdatePhaseService(phaseRepository, phaseSaver);
    }

    @Test
    public void update() {
        doReturn(Optional.of(phase)).when(phaseRepository).findById(1L);

        subject.update(1L, phase);

        verify(phase).setId(1L);
        verify(phaseSaver).save(phase);
    }

    @Test
    public void dontUpdateForUnexistentId() {
        doReturn(Optional.empty()).when(phaseRepository).findById(1L);

        assertThrows(PhaseNotFoundException.class, () -> subject.update(1L, phase));

        verify(phaseRepository).findById(1L);
        verifyNoMoreInteractions(phase);
        verifyNoMoreInteractions(phaseRepository);
        verifyNoMoreInteractions(phaseSaver);
    }
}