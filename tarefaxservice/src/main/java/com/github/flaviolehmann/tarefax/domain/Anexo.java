package com.github.flaviolehmann.tarefax.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "anexo")
@Getter
@Setter
public class Anexo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", length = 80)
    private String titulo;

    @Column(name = "hash", length = 400, nullable = false)
    private String hash;

    @Column(name = "tamanho", length = 400)
    private String tamanho;

    @Column(name = "tipo", length = 400)
    private String tipo;

    @Column(name = "tarefa_id")
    private Long idTarefa;
}
