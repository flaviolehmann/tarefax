package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.service.dto.DocumentoDTO;
import com.flaviolehmann.tarefax.service.service.feign.DocumentosClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentosClient documentosClient;

    public InputStream obterPorHash(String hash) {
        DocumentoDTO documentoDTO = Optional.ofNullable(documentosClient.recuperar(hash).getBody())
                .orElseThrow(RuntimeException::new);
        return new ByteArrayInputStream(documentoDTO.getConteudo().getBytes());
    }

}
