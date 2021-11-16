package com.github.flaviolehmann.tarefax.repository;

import com.github.flaviolehmann.tarefax.domain.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {

    void deleteByHash(String hash);

    Optional<Anexo> findByHash(String hash);
}
