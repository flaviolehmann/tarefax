package com.flaviolehmann.tarefax.service.service.mapper;

import com.flaviolehmann.tarefax.service.domain.Responsavel;
import com.flaviolehmann.tarefax.service.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper extends EntityMapper<ResponsavelDTO, Responsavel> {
}
