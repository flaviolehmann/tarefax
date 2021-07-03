package com.flaviolehmann.tarefax.service.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "tarefax-tarefas")
@Setting(settingPath = "config/elasticsearch/elasticsearch-config.json")
public class TarefaDocument {

    private Long id;
    private String titulo;
    private LocalDate dataInicioPrevista;
    private LocalDate dataTerminoPrevista;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String nomeResponsavel;
}
