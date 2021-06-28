package com.flaviolehmann.tarefax.service.web.rest;

import com.flaviolehmann.tarefax.service.service.TarefaService;
import com.flaviolehmann.tarefax.service.service.dto.TarefaDTO;
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
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResource {

    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> obterTodos() {
        return ResponseEntity.ok(tarefaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(tarefaService.obterPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<TarefaDTO>> deletar(@PathVariable("id") Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> criar(@RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok(tarefaService.salvar(tarefaDTO));
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> atualizar(@RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok(tarefaService.salvar(tarefaDTO));
    }

}
