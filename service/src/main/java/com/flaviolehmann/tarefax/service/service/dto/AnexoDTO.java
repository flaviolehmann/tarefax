package com.flaviolehmann.tarefax.service.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AnexoDTO implements Serializable {

    private Long id;
    private String titulo;
    private String hash;
    private String tipo;
    private String conteudo;
    private String tamanho;
    private Long idTarefa;
}
