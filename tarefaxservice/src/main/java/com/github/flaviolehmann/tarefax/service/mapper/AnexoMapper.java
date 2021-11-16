package com.github.flaviolehmann.tarefax.service.mapper;

import com.github.flaviolehmann.tarefax.domain.Anexo;
import com.github.flaviolehmann.tarefax.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnexoMapper extends EntityMapper<AnexoDTO, Anexo> {

}
