package com.flaviolehmann.tarefax.service.web.rest;

import com.flaviolehmann.tarefax.service.service.DocumentoService;
import com.flaviolehmann.tarefax.service.service.dto.AnexoDTO;
import com.flaviolehmann.tarefax.service.service.error.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.util.Base64;

@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
@Slf4j
public class DocumentoResource {

    private final DocumentoService documentoService;

    @GetMapping("/{hash}")
    public ResponseEntity<Resource> download(@PathVariable("hash") String hash) {
        AnexoDTO anexoDTO = documentoService.obterPorHash(hash);
        byte[] content = Base64.getDecoder().decode(anexoDTO.getConteudo());
        return ResponseEntity.ok()
                .headers(getHeadersParaBaixarDocumento(anexoDTO))
                .contentLength(content.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(
                        new ByteArrayInputStream(content)));
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView registroNaoEncontradoException() {
        return new ModelAndView("error");
    }

    private HttpHeaders getHeadersParaBaixarDocumento(AnexoDTO anexoDTO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
        httpHeaders.add("Pragma", "no-cache");
        httpHeaders.add("Expires", "0");
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + anexoDTO.getFileName());
        return httpHeaders;
    }

}
