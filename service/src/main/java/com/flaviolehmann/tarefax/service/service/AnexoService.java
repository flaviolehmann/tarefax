package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.domain.Anexo;
import com.flaviolehmann.tarefax.service.domain.Tarefa;
import com.flaviolehmann.tarefax.service.repository.AnexoRepository;
import com.flaviolehmann.tarefax.service.service.dto.AnexoDTO;
import com.flaviolehmann.tarefax.service.service.dto.DocumentoDTO;
import com.flaviolehmann.tarefax.service.service.feign.DocumentosClient;
import com.flaviolehmann.tarefax.service.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AnexoService {

    private final DocumentosClient documentosClient;
    private final AnexoRepository anexoRepository;
    private final AnexoMapper anexoMapper;

    public AnexoDTO salvar(AnexoDTO anexoDTO) {
        String hash = persistirNoMinio(anexoDTO);
        anexoDTO.setHash(hash);
        anexoDTO.setTamanho(anexoDTO.getConteudo().length() + " KB");
        return anexoMapper.toDto(persistirAnexo(anexoDTO));
    }

    private Anexo persistirAnexo(AnexoDTO anexoDTO) {
        Anexo anexo = anexoMapper.toEntity(anexoDTO);
        return anexoRepository.save(anexo);
    }

    public AnexoDTO obterPorId(Long id) {
        return anexoMapper.toDto(findById(id));
    }

    public List<AnexoDTO> obterTodos() {
        return anexoMapper.toDto(anexoRepository.findAll());
    }

    public void deletar(Long idAnexo) {
        String hash = findById(idAnexo).getHash();
        anexoRepository.deleteByHash(hash);
        documentosClient.excluir(hash);
    }

    private String persistirNoMinio(AnexoDTO anexoDTO) {
        DocumentoDTO documentoDTO = DocumentoDTO.builder()
                .conteudo(anexoDTO.getConteudo())
                .uuid(UUID.randomUUID().toString()).build();
        return documentosClient.salvar(documentoDTO).getBody();
    }

    private Anexo findById(Long idAnexo) {
        return anexoRepository.findById(idAnexo).orElseThrow(RuntimeException::new);
    }

}
