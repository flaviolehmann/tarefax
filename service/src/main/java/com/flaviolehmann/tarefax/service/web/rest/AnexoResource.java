package com.flaviolehmann.tarefax.service.web.rest;

import com.flaviolehmann.tarefax.service.service.AnexoService;
import com.flaviolehmann.tarefax.service.service.dto.AnexoDTO;
import com.flaviolehmann.tarefax.service.service.dto.TarefaDTO;
import com.flaviolehmann.tarefax.service.service.feign.TesteClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/anexos")
@RequiredArgsConstructor
public class AnexoResource {

    private final AnexoService anexoService;
    private final TesteClient testeClient;

    @GetMapping
    public ResponseEntity<String> obterTodos() {
        return ResponseEntity.ok(testeClient.teste().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> obterPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testeClient.teste().getBody());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<TarefaDTO>> deletar(@PathVariable("id") Long id) {
        anexoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<AnexoDTO> criar(@RequestBody AnexoDTO anexoDTO) {
        return ResponseEntity.ok(anexoService.salvar(anexoDTO));
    }

    @PutMapping
    public ResponseEntity<AnexoDTO> atualizar(@RequestBody AnexoDTO anexoDTO) {
        return ResponseEntity.ok(anexoService.salvar(anexoDTO));
    }

}
