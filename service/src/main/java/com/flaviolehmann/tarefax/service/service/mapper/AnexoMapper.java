package com.flaviolehmann.tarefax.service.service.mapper;

import com.flaviolehmann.tarefax.service.domain.Anexo;
import com.flaviolehmann.tarefax.service.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnexoMapper extends EntityMapper<AnexoDTO, Anexo> {
}
