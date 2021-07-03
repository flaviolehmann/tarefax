package com.flaviolehmann.tarefax.service.service;

import com.flaviolehmann.tarefax.service.domain.Anexo;
import com.flaviolehmann.tarefax.service.repository.AnexoRepository;
import com.flaviolehmann.tarefax.service.service.dto.AnexoDTO;
import com.flaviolehmann.tarefax.service.service.dto.DocumentoDTO;
import com.flaviolehmann.tarefax.service.service.error.RegistroNaoEncontradoException;
import com.flaviolehmann.tarefax.service.service.feign.DocumentosClient;
import com.flaviolehmann.tarefax.service.service.mapper.AnexoMapper;
import com.flaviolehmann.tarefax.service.service.util.TarefaxConstantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.text.NumberFormat;
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
        formatarTamanho(anexoDTO);
        String hash = persistirNoMinio(anexoDTO);
        anexoDTO.setHash(hash);
        return anexoMapper.toDto(persistirAnexo(anexoDTO));
    }

    public AnexoDTO obterPorId(Long idAnexo) {
        return anexoRepository.findById(idAnexo).map(anexoMapper::toDto)
                .orElseThrow(RegistroNaoEncontradoException::new);
    }

    public List<AnexoDTO> obterTodos() {
        return anexoMapper.toDto(anexoRepository.findAll());
    }

    public void deletar(Long idAnexo) {
        String hash = obterPorId(idAnexo).getHash();
        anexoRepository.deleteByHash(hash);
        documentosClient.excluir(hash);
    }

    private void formatarTamanho(AnexoDTO anexoDTO) {
        String tamanhoFormatado = MessageFormat.format("{0} {1}",
                NumberFormat.getNumberInstance().format(anexoDTO.getConteudo().length()),
                TarefaxConstantes.UNIDADE_MEDIDA_TAMANHO);
        anexoDTO.setTamanho(tamanhoFormatado);
    }

    private String persistirNoMinio(AnexoDTO anexoDTO) {
        DocumentoDTO documentoDTO = DocumentoDTO.builder()
                .conteudo(anexoDTO.getConteudo())
                .uuid(UUID.randomUUID().toString()).build();
        return documentosClient.salvar(documentoDTO).getBody();
    }

    private Anexo persistirAnexo(AnexoDTO anexoDTO) {
        Anexo anexo = anexoMapper.toEntity(anexoDTO);
        return anexoRepository.save(anexo);
    }

}
