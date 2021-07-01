package com.flaviolehmann.tarefax.service.repository;

import com.flaviolehmann.tarefax.service.domain.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {

    void deleteByHash(String hash);

}
