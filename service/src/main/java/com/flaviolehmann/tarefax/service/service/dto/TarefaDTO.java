package com.flaviolehmann.tarefax.service.service.dto;

import com.flaviolehmann.tarefax.service.domain.enumeration.StatusTarefa;
import com.flaviolehmann.tarefax.service.domain.enumeration.TipoTarefa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TarefaDTO implements Serializable {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataInicioPrevista;
    private LocalDate dataTerminoPrevista;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private TipoTarefa tipo = TipoTarefa.TESTE;
    private StatusTarefa status = StatusTarefa.ATIVO;
    private String comentarios;
    private ResponsavelDTO responsavel;
    private List<AnexoDTO> anexos = new ArrayList<>();
}
