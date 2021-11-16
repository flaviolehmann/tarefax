package com.github.flaviolehmann.tarefax.service.feign;

import com.github.flaviolehmann.tarefax.service.dto.DocumentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "documentos", url = "${application.feign.url}")
public interface DocumentosClient {

    @GetMapping("/api/documentos/{hash}")
    ResponseEntity<DocumentoDTO> recuperar(@PathVariable("hash") String hash);

    @PutMapping("/api/documentos")
    ResponseEntity<String> salvar(@RequestBody DocumentoDTO documentoDTO);

    @DeleteMapping("/api/documentos/{hash}")
    ResponseEntity<Void> excluir(@PathVariable("hash") String hash);
}
