package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.repository.ResponsavelRepository;
import com.flaviolehmann.tarefax.service.service.dto.ResponsavelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;

    public ResponsavelDTO salvar(ResponsavelDTO responsavelDTO) {
        return new ResponsavelDTO();
    }

    public ResponsavelDTO obterPorId(Long idTarefa) {
        return new ResponsavelDTO();
    }

    public List<ResponsavelDTO> obterTodos() {
        return new ArrayList<>();
    }

    public void deletar(Long idResponsavel) {
        responsavelRepository.deleteById(idResponsavel);
    }

}
