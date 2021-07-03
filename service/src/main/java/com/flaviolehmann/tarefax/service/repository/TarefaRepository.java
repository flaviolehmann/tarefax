package com.flaviolehmann.tarefax.service.repository;

import com.flaviolehmann.tarefax.service.domain.Tarefa;
import com.flaviolehmann.tarefax.service.service.projection.TarefaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    TarefaProjection getById(Long id);

}
