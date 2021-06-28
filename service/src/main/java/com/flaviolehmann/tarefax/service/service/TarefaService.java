package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.repository.TarefaRepository;
import com.flaviolehmann.tarefax.service.service.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaDTO salvar(TarefaDTO tarefaDTO) {
        return new TarefaDTO();
    }

    public TarefaDTO obterPorId(Long idTarefa) {
        return new TarefaDTO();
    }

    public List<TarefaDTO> obterTodos() {
        return new ArrayList<>();
    }

    public void deletar(Long idTarefa) {
        tarefaRepository.deleteById(idTarefa);
    }
}
