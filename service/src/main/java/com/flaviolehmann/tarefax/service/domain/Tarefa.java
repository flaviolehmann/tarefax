package com.flaviolehmann.tarefax.service.domain;


import com.flaviolehmann.tarefax.service.domain.enumeration.StatusTarefa;
import com.flaviolehmann.tarefax.service.domain.enumeration.TipoTarefa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", length = 80)
    private String titulo;

    @Column(name = "DESCRICAO", length = 400)
    private String descricao;

    @Column(name = "data_inicio_prevista")
    private LocalDate dataInicioPrevista;

    @Column(name = "data_termino_prevista")
    private LocalDate dataTerminoPrevista;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_termino")
    private LocalDate dataTermino;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTarefa tipo;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTarefa status = StatusTarefa.ATIVO;

    @Column(name = "comentarios", length = 2000)
    private String comentarios;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tarefa_id")
    private List<Anexo> anexos = new ArrayList<>();

    @ManyToOne
    private Responsavel responsavel;

    public Tarefa(Long id) {
        this.id = id;
    }

    public Tarefa() {
    }
}
