package com.flaviolehmann.tarefax.service.repository;

import com.flaviolehmann.tarefax.service.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}
