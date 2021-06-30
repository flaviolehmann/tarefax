package com.flaviolehmann.tarefax.service.service.feign;

import com.flaviolehmann.tarefax.service.service.dto.DocumentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "documentos", url = "${application.feign.url}/api/documentos")
public interface DocumentosClient {

    @GetMapping("/{hash}")
    ResponseEntity<DocumentoDTO> recuperar(@PathVariable String hash);

    @PutMapping
    ResponseEntity<DocumentoDTO> salvar(@RequestBody DocumentoDTO documentoDTO);

    @DeleteMapping("/{hash}")
    ResponseEntity<Void> excluir(@PathVariable String hash);

}
