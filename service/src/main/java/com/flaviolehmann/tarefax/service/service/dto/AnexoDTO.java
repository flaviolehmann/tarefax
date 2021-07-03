package com.flaviolehmann.tarefax.service.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;

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

    public AnexoDTO atualizarComDocumentoDTO(DocumentoDTO documentoDTO) {
        conteudo = documentoDTO.getConteudo();
        hash = documentoDTO.getUuid();
        return this;
    }

    public Long getTamanhoAsLong() {
        return Arrays.stream(tamanho.replace(".", "").split(" "))
                .findFirst().map(Long::parseLong).orElse(null);
    }

    public String getFileName() {
        return MessageFormat.format("{0}.{1}", titulo, tipo.toLowerCase());
    }

}
