package com.flaviolehmann.tarefax.documentos.service;

import ch.qos.logback.core.util.ContentTypeUtil;
import com.flaviolehmann.tarefax.documentos.config.ApplicationProperties;
import com.flaviolehmann.tarefax.documentos.service.dto.DocumentoDTO;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final ApplicationProperties applicationProperties;
    private final MinioClient minioClient;

    @SneakyThrows
    public DocumentoDTO recuperar(String uuid) {
        InputStream object = minioClient.getObject(GetObjectArgs.builder()
                .bucket(applicationProperties.getMinio().getBucket())
                .object(uuid).build());
        return documentoDTOFromConteudo(uuid, object);
    }

    @SneakyThrows
    public String salvar(DocumentoDTO documentoDTO) {
        String conteudo = documentoDTO.getConteudo();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(applicationProperties.getMinio().getBucket())
                .object(documentoDTO.getUuid())
                .stream(new ByteArrayInputStream(conteudo.getBytes()), conteudo.getBytes().length, 0)
                .contentType(StandardCharsets.UTF_8.toString()).build());
        return documentoDTO.getUuid();
    }

    @SneakyThrows
    public void excluir(String uuid) {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(applicationProperties.getMinio().getBucket())
                .object(uuid)
                .build());
    }

    private DocumentoDTO documentoDTOFromConteudo(String uuid, InputStream inputStream) {
        String conteudo = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));
        return DocumentoDTO.builder()
                .uuid(uuid)
                .conteudo(conteudo).build();
    }
}
