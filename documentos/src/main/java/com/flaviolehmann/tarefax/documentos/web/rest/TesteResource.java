package com.flaviolehmann.tarefax.documentos.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
@RequiredArgsConstructor
public class TesteResource {

    @GetMapping
    public ResponseEntity<String> obterTodos() {
        return ResponseEntity.ok("Hello, Feign!");
    }

}
