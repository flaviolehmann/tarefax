package com.flaviolehmann.tarefax.service.repository;

import com.flaviolehmann.tarefax.service.domain.Tarefa;
import com.flaviolehmann.tarefax.service.service.projection.TarefaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>, Reindexer<Tarefa> {

    TarefaProjection getById(Long id);

    @Override
    @Query(
        "SELECT new com.flaviolehmann.tarefax.service.domain.document.TarefaDocument(" +
        "   t.id," +
        "   t.titulo," +
        "   t.dataInicioPrevista," +
        "   t.dataTerminoPrevista," +
        "   t.dataInicio," +
        "   t.dataTermino, " +
        "   t.responsavel.nome " +
        ") FROM " +
        "   Tarefa t " +
        "ORDER BY " +
        "   t.id ")
    Page<Tarefa> reindexPage(Pageable page);

    @Override
    default String getEntity() {
        return "tarefax-tarefas";
    }

}
