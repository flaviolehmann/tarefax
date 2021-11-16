package com.github.flaviolehmann.tarefax.service;

import com.github.flaviolehmann.tarefax.domain.Tarefa;
import com.github.flaviolehmann.tarefax.repository.TarefaRepository;
import com.github.flaviolehmann.tarefax.service.dto.TarefaDTO;
import com.github.flaviolehmann.tarefax.service.error.RegistroNaoEncontradoException;
import com.github.flaviolehmann.tarefax.service.event.TarefaEvent;
import com.github.flaviolehmann.tarefax.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    public TarefaDTO salvar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaRepository.save(tarefaMapper.toEntity(tarefaDTO));
        applicationEventPublisher.publishEvent(new TarefaEvent(tarefa.getId()));
        return tarefaMapper.toDto(tarefa);
    }

    public TarefaDTO obterPorId(Long idTarefa) {
        return tarefaRepository.findById(idTarefa).map(tarefaMapper::toDto)
            .orElseThrow(RegistroNaoEncontradoException::new);
    }

    public List<TarefaDTO> obterTodos() {
        return tarefaMapper.toDto(tarefaRepository.findAll());
    }

    public void deletar(Long idTarefa) {
        obterPorId(idTarefa);
        tarefaRepository.deleteById(idTarefa);
    }
}
