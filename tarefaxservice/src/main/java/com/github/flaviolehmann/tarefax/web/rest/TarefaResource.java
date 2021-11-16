package com.github.flaviolehmann.tarefax.web.rest;

import com.github.flaviolehmann.tarefax.domain.document.TarefaDocument;
import com.github.flaviolehmann.tarefax.service.TarefaFiltro;
import com.github.flaviolehmann.tarefax.service.TarefaService;
import com.github.flaviolehmann.tarefax.service.dto.MailDTO;
import com.github.flaviolehmann.tarefax.service.dto.TarefaDTO;
import com.github.flaviolehmann.tarefax.service.elasticsearch.TarefaSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private final TarefaSearchService tarefaSearchService;

    @Qualifier("mailRabbitTemplate")
    private final RabbitTemplate mailRabbitTemplate;

    @PostMapping("/_search")
    public ResponseEntity<Page<TarefaDocument>> search(@RequestBody TarefaFiltro filtro, Pageable pageable) {
        return ResponseEntity.ok(tarefaSearchService.search(filtro, pageable));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> obterTodos() {
        return ResponseEntity.ok(tarefaService.obterTodos());
    }

    @GetMapping("/teste")
    public ResponseEntity<TarefaDTO> obterPorId(@ModelAttribute MailDTO mailDTO) {
        mailRabbitTemplate.convertAndSend(mailDTO);
        return null; //ResponseEntity.ok(tarefaService.obterPorId(id));
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
