package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.domain.Responsavel;
import com.flaviolehmann.tarefax.service.repository.ResponsavelRepository;
import com.flaviolehmann.tarefax.service.service.dto.ResponsavelDTO;
import com.flaviolehmann.tarefax.service.service.error.RegistroNaoEncontradoException;
import com.flaviolehmann.tarefax.service.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;
    private final ResponsavelMapper responsavelMapper;

    public ResponsavelDTO salvar(ResponsavelDTO responsavelDTO) {
        responsavelDTO.setSituacao(Boolean.TRUE);
        Responsavel responsavel = responsavelRepository.save(responsavelMapper.toEntity(responsavelDTO));
        return responsavelMapper.toDto(responsavel);
    }

    public ResponsavelDTO obterPorId(Long idResponsavel) {
        return responsavelRepository.findById(idResponsavel).map(responsavelMapper::toDto)
                .orElseThrow(RegistroNaoEncontradoException::new);
    }

    public List<ResponsavelDTO> obterTodos() {
        return responsavelMapper.toDto(responsavelRepository.findAll());
    }

    public void deletar(Long idResponsavel) {
        obterPorId(idResponsavel);
        responsavelRepository.deleteById(idResponsavel);
    }

}
