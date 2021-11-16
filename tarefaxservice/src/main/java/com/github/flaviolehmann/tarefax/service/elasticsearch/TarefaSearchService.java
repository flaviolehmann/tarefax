package com.github.flaviolehmann.tarefax.service.elasticsearch;

import com.github.flaviolehmann.tarefax.domain.document.TarefaDocument;
import com.github.flaviolehmann.tarefax.repository.TarefaRepository;
import com.github.flaviolehmann.tarefax.repository.elasticsearch.TarefaSearchRepository;
import com.github.flaviolehmann.tarefax.service.TarefaFiltro;
import com.github.flaviolehmann.tarefax.service.event.TarefaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
public class TarefaSearchService {

    private final TarefaRepository tarefaRepository;
    private final TarefaSearchRepository tarefaSearchRepository;

    @TransactionalEventListener(fallbackExecution = true)
    @Transactional
    public void indexar(TarefaEvent event) {
        log.info("Indexando tarefa: {}", event.getId());
        TarefaDocument document = tarefaRepository.getById(event.getId()).getDocument();
        tarefaSearchRepository.save(document);
    }

    public Page<TarefaDocument> search(TarefaFiltro tarefaFiltro, Pageable pageable) {
        return tarefaSearchRepository.search(tarefaFiltro.getFilter(), pageable);
    }

}
