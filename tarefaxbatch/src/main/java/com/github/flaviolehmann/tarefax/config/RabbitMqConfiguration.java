package com.github.flaviolehmann.tarefax.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Value("${application.rabbitmq.exchanges.mail-ex}")
    private String mailExchange;

    @Value("${application.rabbitmq.queues.mail-queue}")
    private String mailQueue;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public FanoutExchange mailExchange() {
        return new FanoutExchange(mailExchange);
    }

    @Bean
    public Queue mailQueue() {
        return new Queue(mailQueue);
    }

    @Bean
    public Binding mailBinding(FanoutExchange mailExchange, Queue mailQueue) {
        return BindingBuilder.bind(mailQueue).to(mailExchange);
    }
}
