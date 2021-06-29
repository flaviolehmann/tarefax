package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.service.dto.AnexoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnexoService {

    public AnexoDTO salvar(AnexoDTO anexoDTO) {
        return anexoDTO;
    }

    public AnexoDTO obterPorId(Long idAnexo) {
        return new AnexoDTO();
    }

    public List<AnexoDTO> obterTodos() {
        return Collections.singletonList(new AnexoDTO());
    }

    public void deletar(Long idAnexo) {
    }
}
