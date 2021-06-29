package com.flaviolehmann.tarefax.documentos.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application")
@Getter
@Setter
public class ApplicationProperties {

    private final MinioProperties minio = new MinioProperties();

    @Getter
    @Setter
    public static class MinioProperties {
        private String url;
        private String bucket;
        private String accessKey;
        private String secretKey;
    }

}
