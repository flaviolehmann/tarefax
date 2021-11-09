package com.flaviolehmann.tarefax.service.web.rest;

import com.flaviolehmann.tarefax.service.service.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elasticsearch/reindex")
@RequiredArgsConstructor
@Slf4j
public class ElasticsearchResource {

    private final ElasticsearchService elasticsearchService;

    @GetMapping
    public ResponseEntity<String> reindexAll() {
        log.info("Reindexando todos os índices.");
        elasticsearchService.reindex();
        return ResponseEntity.ok("Reindexando todos os índices...");
    }

    @GetMapping("/{entity}")
    public ResponseEntity<String> reindexEntity(@PathVariable("entity") String entity) {
        log.info("Reindexando o índice {}", entity);
        elasticsearchService.reindexEntity(entity);
        return ResponseEntity.ok("Reindexando o índice " + entity + "...");
    }

}
