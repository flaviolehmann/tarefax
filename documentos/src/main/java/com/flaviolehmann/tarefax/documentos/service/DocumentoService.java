package com.flaviolehmann.tarefax.documentos.service;

import com.flaviolehmann.tarefax.documentos.service.dto.DocumentoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    public DocumentoDTO recuperar(String hash) {
        return new DocumentoDTO();
    }

    public DocumentoDTO salvar(DocumentoDTO documentoDTO) {
        return documentoDTO;
    }

    public void excluir(String hash) {
    }
}
