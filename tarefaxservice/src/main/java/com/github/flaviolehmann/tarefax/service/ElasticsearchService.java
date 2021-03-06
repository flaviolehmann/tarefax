package com.github.flaviolehmann.tarefax.service;

import com.github.flaviolehmann.tarefax.repository.Reindexer;
import com.github.flaviolehmann.tarefax.repository.elasticsearch.TarefaxRepository;
import com.github.flaviolehmann.tarefax.service.error.FalhaIndexacaoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElasticsearchService {

    private final List<Reindexer> reindexadores;
    private final List<TarefaxRepository> repositories;
    private final ElasticsearchOperations elasticsearchOperations;
    @Value("${nuvem.elasticsearch.reindex.pageSize:10000}")
    private Integer pageSize;

    @Transactional(readOnly = true)
    @Async
    public void reindex() {
        log.info("Starting reindex.");
        for (Reindexer reindexer : reindexadores) {
            reindex(reindexer);
        }
    }

    @Transactional(readOnly = true)
    @Async
    public void reindexEntity(String entity) {
        log.info("Starting reindex entity: {}", entity);
        for (Reindexer reindexer : reindexadores) {
            if (reindexer.getEntity().equals(entity)) {
                reindex(reindexer);
            }
        }
    }

    private void reindex(Reindexer<?> bean) {
        Pageable pageable = PageRequest.of(0, pageSize);
        Page<?> page = bean.reindexPage(pageable);
        log.info("Objects found {}.", page.getTotalElements());
        if (!page.hasContent()) {
            return;
        }
        log.info("Total Pages {}.", page.getTotalPages());
        TarefaxRepository searchRepository = getSearchRepository(page);
        recreateIndexDocument(searchRepository.getEntityClass());

        while (page.hasContent()) {
            log.info("Page Number {}.", page.getNumber());
            searchRepository.saveAll(page);
            page = bean.reindexPage(page.getPageable().next());
        }

        log.info("Finish reindex of {}.", bean.getEntity());
    }

    private TarefaxRepository getSearchRepository(Page<?> page) {
        Class documentClass = page.getContent().get(0).getClass();
        Iterator<TarefaxRepository> var3 = this.repositories.iterator();

        TarefaxRepository searchRepository;
        do {
            if (!var3.hasNext()) {
                throw new FalhaIndexacaoException();
            }

            searchRepository = var3.next();
        } while (!searchRepository.getEntityClass().equals(documentClass));

        return searchRepository;
    }

    private void recreateIndexDocument(Class<?> entityClass) {
        log.info("Recriate index class: {}", entityClass.getName());
        elasticsearchOperations.deleteIndex(entityClass);
        elasticsearchOperations.createIndex(entityClass);
        elasticsearchOperations.putMapping(entityClass);
    }
}
