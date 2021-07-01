package com.flaviolehmann.tarefax.service.web.rest;

import com.flaviolehmann.tarefax.service.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
@Slf4j
public class DocumentoResource {

    private final DocumentoService documentoService;

    @GetMapping("/{hash}")
    public void obterPorId(@PathVariable("hash") String hash, HttpServletResponse response) {
        try (InputStream is = documentoService.obterPorHash(hash)) {
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        }
        catch (IOException ex) {
            log.info("Falha ao obter arquivo");
        }
    }

}
