package com.github.flaviolehmann.tarefax.service.projection;


import com.github.flaviolehmann.tarefax.domain.Responsavel;
import com.github.flaviolehmann.tarefax.domain.document.TarefaDocument;

import java.time.LocalDate;

public interface TarefaProjection {

    Long getId();

    String getTitulo();

    LocalDate getDataInicioPrevista();

    LocalDate getDataTerminoPrevista();

    LocalDate getDataInicio();

    LocalDate getDataTermino();

    Responsavel getResponsavel();

    default TarefaDocument getDocument() {
        return TarefaDocument.builder()
            .id(getId())
            .titulo(getTitulo())
            .dataInicio(getDataInicio())
            .dataTermino(getDataTermino())
            .dataInicioPrevista(getDataInicioPrevista())
            .nomeResponsavel(getResponsavel().getNome())
            .dataTerminoPrevista(getDataTerminoPrevista()).build();
    }
}
