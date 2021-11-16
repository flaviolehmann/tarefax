package com.github.flaviolehmann.tarefax.service;

import com.github.flaviolehmann.tarefax.service.dto.AnexoDTO;
import com.github.flaviolehmann.tarefax.service.error.RegistroNaoEncontradoException;
import com.github.flaviolehmann.tarefax.service.feign.DocumentosClient;
import feign.FeignException;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentosClient documentosClient;
    private final AnexoService anexoService;

    public AnexoDTO obterPorHash(String hash) {
        try {
            return anexoService.obterPorHash(hash)
                .atualizarComDocumentoDTO(
                    Optional.ofNullable(documentosClient.recuperar(hash).getBody())
                        .orElseThrow(RegistroNaoEncontradoException::new));
        } catch (FeignException e) {
            if (HttpResponseStatus.NOT_FOUND.code() == e.status()) {
                throw new RegistroNaoEncontradoException();
            }
            return new AnexoDTO();
        }
    }

}
