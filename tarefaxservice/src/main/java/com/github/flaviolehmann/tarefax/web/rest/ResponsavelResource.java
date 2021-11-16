package com.github.flaviolehmann.tarefax.web.rest;

import com.github.flaviolehmann.tarefax.service.ResponsavelService;
import com.github.flaviolehmann.tarefax.service.dto.ResponsavelDTO;
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
@RequestMapping("/api/responsaveis")
@RequiredArgsConstructor
public class ResponsavelResource {

    private final ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> obterTodos() {
        return ResponseEntity.ok(responsavelService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> obterPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(responsavelService.obterPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<ResponsavelDTO>> deletar(@PathVariable("id") Long id) {
        responsavelService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ResponsavelDTO> criar(@RequestBody ResponsavelDTO responsavelDTO) {
        return ResponseEntity.ok(responsavelService.salvar(responsavelDTO));
    }

    @PutMapping
    public ResponseEntity<ResponsavelDTO> atualizar(@RequestBody ResponsavelDTO responsavelDTO) {
        return ResponseEntity.ok(responsavelService.salvar(responsavelDTO));
    }
}
