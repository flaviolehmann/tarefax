package com.github.flaviolehmann.tarefax.domain.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "tarefax-tarefas")
@Setting(settingPath = "config/elasticsearch/elasticsearch-config.json")
public class TarefaDocument {

    public static final String ANALYZER = "trim_case_insensitive";

    @Field(type = FieldType.Long)
    private Long id;

    @MultiField(mainField = @Field(type = FieldType.Text, analyzer = ANALYZER, store = true, fielddata = true),
        otherFields = {@InnerField(suffix = "sort", type = FieldType.Keyword)})
    private String titulo;

    @Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataInicioPrevista;

    @Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataTerminoPrevista;

    @Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataTermino;

    @MultiField(mainField = @Field(type = FieldType.Text, analyzer = ANALYZER, store = true, fielddata = true),
        otherFields = {@InnerField(suffix = "sort", type = FieldType.Keyword)})
    private String nomeResponsavel;
}
