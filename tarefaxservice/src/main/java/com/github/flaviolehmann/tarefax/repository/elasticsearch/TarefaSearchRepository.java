package com.github.flaviolehmann.tarefax.repository.elasticsearch;

import com.github.flaviolehmann.tarefax.domain.document.TarefaDocument;

public interface TarefaSearchRepository extends TarefaxRepository<TarefaDocument, Long> {

    @Override
    default Class<TarefaDocument> getEntityClass() {
        return TarefaDocument.class;
    }
}
