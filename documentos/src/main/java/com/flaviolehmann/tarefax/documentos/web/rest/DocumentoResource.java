package com.flaviolehmann.tarefax.documentos.web.rest;

import com.flaviolehmann.tarefax.documentos.service.DocumentoService;
import com.flaviolehmann.tarefax.documentos.service.dto.DocumentoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoResource {

    private final DocumentoService documentoService;

    @GetMapping("/{uuid}")
    public ResponseEntity<DocumentoDTO> recuperar(@PathVariable String uuid) {
        return ResponseEntity.ok(documentoService.recuperar(uuid));
    }

    @PutMapping
    public ResponseEntity<String> salvar(@RequestBody DocumentoDTO documentoDTO) {
        return ResponseEntity.ok(documentoService.salvar(documentoDTO));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> excluir(@PathVariable String uuid) {
        documentoService.excluir(uuid);
        return ResponseEntity.noContent().build();
    }

}
