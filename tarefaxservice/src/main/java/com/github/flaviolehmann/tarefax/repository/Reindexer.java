package com.github.flaviolehmann.tarefax.repository;

import com.github.flaviolehmann.tarefax.service.error.FalhaIndexacaoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Reindexer<T> {

    Page<T> reindexPage(Pageable page);

    default String getEntity() {
        throw new FalhaIndexacaoException();
    }
}
