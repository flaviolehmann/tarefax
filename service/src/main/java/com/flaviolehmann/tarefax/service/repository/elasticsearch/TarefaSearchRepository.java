package com.flaviolehmann.tarefax.service.repository.elasticsearch;

import com.flaviolehmann.tarefax.service.domain.document.TarefaDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TarefaSearchRepository extends ElasticsearchRepository<TarefaDocument, Long> {
}
