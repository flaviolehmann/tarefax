package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.service.elasticsearch.BaseFilter;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;

public class TarefaFiltro implements Serializable, BaseFilter {

    private String titulo;
    private String nomeResponsavel;

    @Override
    public BoolQueryBuilder getFilter() {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        addShouldTermQuery(queryBuilder, "titulo", titulo);
        addShouldTermQuery(queryBuilder, "nomeResponsavel", nomeResponsavel);
        return queryBuilder;
    }
}
