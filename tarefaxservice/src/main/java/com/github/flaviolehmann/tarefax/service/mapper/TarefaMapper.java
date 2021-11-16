package com.github.flaviolehmann.tarefax.service.mapper;

import com.github.flaviolehmann.tarefax.domain.Tarefa;
import com.github.flaviolehmann.tarefax.service.dto.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AnexoMapper.class, ResponsavelMapper.class})
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {
}
