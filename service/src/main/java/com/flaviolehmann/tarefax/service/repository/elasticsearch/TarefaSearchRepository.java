package com.flaviolehmann.tarefax.service.repository.elasticsearch;

import com.flaviolehmann.tarefax.service.domain.document.TarefaDocument;

public interface TarefaSearchRepository extends TarefaxRepository<TarefaDocument, Long> {

    @Override
    default Class<TarefaDocument> getEntityClass() {
        return TarefaDocument.class;
    }
}
