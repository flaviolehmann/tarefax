package com.flaviolehmann.tarefax.service.service.mapper;

import com.flaviolehmann.tarefax.service.domain.Tarefa;
import com.flaviolehmann.tarefax.service.service.dto.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { AnexoMapper.class, ResponsavelMapper.class })
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {
}
