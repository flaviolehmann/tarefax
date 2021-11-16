package com.github.flaviolehmann.tarefax.service;

import com.github.flaviolehmann.tarefax.domain.Responsavel;
import com.github.flaviolehmann.tarefax.repository.ResponsavelRepository;
import com.github.flaviolehmann.tarefax.service.dto.ResponsavelDTO;
import com.github.flaviolehmann.tarefax.service.error.RegistroNaoEncontradoException;
import com.github.flaviolehmann.tarefax.service.mapper.ResponsavelMapper;
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
