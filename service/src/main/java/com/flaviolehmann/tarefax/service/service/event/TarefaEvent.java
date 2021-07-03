package com.flaviolehmann.tarefax.service.service.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TarefaEvent extends DefaultEvent {

    public TarefaEvent(Long id) {
        super(id);
    }
}
