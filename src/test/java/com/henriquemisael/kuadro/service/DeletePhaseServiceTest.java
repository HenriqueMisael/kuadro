package com.henriquemisael.kuadro.service;

import com.henriquemisael.kuadro.UnitTest;
import com.henriquemisael.kuadro.exception.notfound.PhaseNotFoundException;
import com.henriquemisael.kuadro.model.entity.Phase;
import com.henriquemisael.kuadro.model.repository.PhaseRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class DeletePhaseServiceTest extends UnitTest {

    @Mock
    private PhaseRepository phaseRepository;
    @Mock
    private Phase phase;
    private DeletePhaseService subject;

    @Before
    public void before() {
        subject = new DeletePhaseService(phaseRepository);
    }

    @Test
    public void update() {
        doReturn(Optional.of(phase)).when(phaseRepository).findById(1L);

        subject.delete(1L);

        verify(phaseRepository).delete(phase);
    }

    @Test
    public void dontUpdateForUnexistentId() {
        doReturn(Optional.empty()).when(phaseRepository).findById(1L);

        assertThrows(PhaseNotFoundException.class, () -> subject.delete(1L));

        verify(phaseRepository).findById(1L);
        verifyNoMoreInteractions(phaseRepository);
    }
}