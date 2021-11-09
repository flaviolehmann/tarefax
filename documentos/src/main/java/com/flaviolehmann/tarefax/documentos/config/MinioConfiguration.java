package com.flaviolehmann.tarefax.documentos.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MinioConfiguration {

    private final ApplicationProperties applicationProperties;

    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient = buildMinioClient();
        if (!bucketExists(minioClient)) {
            createBucket(minioClient);
        }
        return minioClient;
    }

    @SneakyThrows
    private boolean bucketExists(MinioClient minioClient) {
        return minioClient.bucketExists(
                BucketExistsArgs.builder().bucket(applicationProperties.getMinio().getBucket()).build());
    }

    @SneakyThrows
    private void createBucket(MinioClient minioClient) {
        minioClient.makeBucket(
                MakeBucketArgs.builder().bucket(applicationProperties.getMinio().getBucket()).build());
    }

    private MinioClient buildMinioClient() {
        ApplicationProperties.MinioProperties minioProperties = applicationProperties.getMinio();
        return MinioClient.builder()
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .endpoint(minioProperties.getUrl()).build();
    }

}
