package com.flaviolehmann.tarefax.documentos.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoDTO {

    private String hash;
    private byte[] conteudo;
}
