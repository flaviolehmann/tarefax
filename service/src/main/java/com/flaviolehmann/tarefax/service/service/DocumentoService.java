package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.domain.Anexo;
import com.flaviolehmann.tarefax.service.repository.AnexoRepository;
import com.flaviolehmann.tarefax.service.service.dto.AnexoDTO;
import com.flaviolehmann.tarefax.service.service.dto.DocumentoDTO;
import com.flaviolehmann.tarefax.service.service.feign.DocumentosClient;
import com.flaviolehmann.tarefax.service.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
