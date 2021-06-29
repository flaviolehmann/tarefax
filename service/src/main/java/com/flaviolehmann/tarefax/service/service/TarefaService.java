package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.domain.Tarefa;
import com.flaviolehmann.tarefax.service.repository.TarefaRepository;
import com.flaviolehmann.tarefax.service.service.dto.TarefaDTO;
import com.flaviolehmann.tarefax.service.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaDTO salvar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaRepository.save(tarefaMapper.toEntity(tarefaDTO));
        return tarefaMapper.toDto(tarefa);
    }

    public TarefaDTO obterPorId(Long idTarefa) {
        return tarefaRepository.findById(idTarefa).map(tarefaMapper::toDto).orElse(null);
    }

    public List<TarefaDTO> obterTodos() {
        return tarefaMapper.toDto(tarefaRepository.findAll());
    }

    public void deletar(Long idTarefa) {
        tarefaRepository.deleteById(idTarefa);
    }
}
