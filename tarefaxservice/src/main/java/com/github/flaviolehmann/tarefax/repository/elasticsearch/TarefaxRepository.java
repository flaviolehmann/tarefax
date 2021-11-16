package com.github.flaviolehmann.tarefax.repository.elasticsearch;

import com.github.flaviolehmann.tarefax.service.error.FalhaIndexacaoException;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TarefaxRepository<T, E> extends ElasticsearchRepository<T, E> {

    default Class<T> getEntityClass() {
        throw new FalhaIndexacaoException();
    }
}
