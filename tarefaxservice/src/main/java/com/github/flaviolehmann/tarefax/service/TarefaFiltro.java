package com.github.flaviolehmann.tarefax.service;

import com.github.flaviolehmann.tarefax.service.elasticsearch.BaseFilter;
import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;
import java.util.Collections;


@Getter
@Setter
public class TarefaFiltro implements Serializable, BaseFilter {

    private String titulo;
    private String nomeResponsavel;

    @Override
    public BoolQueryBuilder getFilter() {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        addShouldWildCard(queryBuilder, Collections.singletonList("titulo"), titulo);
        addShouldWildCard(queryBuilder, Collections.singletonList("nomeResponsavel"), nomeResponsavel);
        return queryBuilder;
    }
}
