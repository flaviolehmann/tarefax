package com.github.flaviolehmann.tarefax.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.github.flaviolehmann.tarefax.service.repository")
@EnableTransactionManagement
public class ElasticSearchConfiguration {
}
