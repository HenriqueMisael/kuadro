package com.henriquemisael.kuadro.model.repository;

import com.henriquemisael.kuadro.model.entity.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long> {
}
