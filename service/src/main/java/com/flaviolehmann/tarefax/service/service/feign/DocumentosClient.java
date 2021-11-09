package com.flaviolehmann.tarefax.service.service.feign;

import com.flaviolehmann.tarefax.service.service.dto.DocumentoDTO;
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
    ResponseEntity<DocumentoDTO> recuperar(@PathVariable String hash);

    @PutMapping("/api/documentos")
    ResponseEntity<String> salvar(@RequestBody DocumentoDTO documentoDTO);

    @DeleteMapping("/api/documentos/{hash}")
    ResponseEntity<Void> excluir(@PathVariable String hash);

}
