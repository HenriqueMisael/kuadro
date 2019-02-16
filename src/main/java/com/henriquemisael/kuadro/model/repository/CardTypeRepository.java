package com.henriquemisael.kuadro.model.repository;

import com.henriquemisael.kuadro.model.entity.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Long> {

}
