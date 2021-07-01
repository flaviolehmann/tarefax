package com.flaviolehmann.tarefax.documentos.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class DocumentoDTO implements Serializable {

    private String uuid;
    private String conteudo;
}

