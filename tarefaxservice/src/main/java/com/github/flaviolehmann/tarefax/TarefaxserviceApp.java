package com.github.flaviolehmann.tarefax;


import br.gov.nuvem.comum.microsservico.util.AppUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class})
@RequiredArgsConstructor
@Slf4j
@EnableFeignClients
@EnableRabbit
public class TarefaxserviceApp implements InitializingBean {

    private final Environment env;

    public static void main(String[] args) {
        AppUtil.startup(args, TarefaxserviceApp.class, log);
    }

    @Override
    public void afterPropertiesSet() {
        AppUtil.checkProfiles(env, log);
    }
}

