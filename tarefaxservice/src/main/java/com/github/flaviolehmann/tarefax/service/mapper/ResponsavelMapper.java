package com.github.flaviolehmann.tarefax.service.mapper;

import com.github.flaviolehmann.tarefax.domain.Responsavel;
import com.github.flaviolehmann.tarefax.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper extends EntityMapper<ResponsavelDTO, Responsavel> {
}
