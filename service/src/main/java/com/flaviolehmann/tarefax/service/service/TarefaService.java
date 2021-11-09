package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.domain.Tarefa;
import com.flaviolehmann.tarefax.service.repository.TarefaRepository;
import com.flaviolehmann.tarefax.service.service.dto.TarefaDTO;
import com.flaviolehmann.tarefax.service.service.error.RegistroNaoEncontradoException;
import com.flaviolehmann.tarefax.service.service.event.TarefaEvent;
import com.flaviolehmann.tarefax.service.service.mapper.TarefaMapper;
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
