package com.flaviolehmann.tarefax.service.service.projection;

import com.flaviolehmann.tarefax.service.domain.Responsavel;
import com.flaviolehmann.tarefax.service.domain.document.TarefaDocument;

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
