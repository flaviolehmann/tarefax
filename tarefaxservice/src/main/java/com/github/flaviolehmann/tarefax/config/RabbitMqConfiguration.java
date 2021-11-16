package com.github.flaviolehmann.tarefax.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Value("${application.rabbitmq.exchanges.elasticsearch-ex}")
    private String elasticsearchExchange;

    @Value("${application.rabbitmq.exchanges.mail-ex}")
    private String mailExchange;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public FanoutExchange elasticsearchExchange() {
        return new FanoutExchange(elasticsearchExchange);
    }

    @Bean
    public FanoutExchange mailExchange() {
        return new FanoutExchange(mailExchange);
    }
}
