package com.github.flaviolehmann.tarefax.web.rest;

import com.github.flaviolehmann.tarefax.service.AnexoService;
import com.github.flaviolehmann.tarefax.service.dto.AnexoDTO;
import com.github.flaviolehmann.tarefax.service.dto.TarefaDTO;
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

    @GetMapping
    public ResponseEntity<List<AnexoDTO>> obterTodos() {
        return ResponseEntity.ok(anexoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDTO> obterPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(anexoService.obterPorId(id));
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
