package com.github.flaviolehmann.tarefax.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class AnexoDTO implements Serializable {

    private static final long serialVersionUID = -8727595503685620392L;

    private Long id;
    private String titulo;
    private String hash;
    private String tipo;
    private String conteudo;
    private String tamanho;
    private Long idTarefa;

    public AnexoDTO(Long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

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
