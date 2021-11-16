package com.github.flaviolehmann.tarefax.service.queue;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

    @Bean
    public RabbitTemplate elasticsearchRabbitTemplate(ConnectionFactory connectionFactory,
                                                      MessageConverter messageConverter,
                                                      @Qualifier("elasticsearchExchange") FanoutExchange elasticsearchExchange) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        template.setExchange(elasticsearchExchange.getName());
        return template;
    }

    @Bean
    public RabbitTemplate mailRabbitTemplate(ConnectionFactory connectionFactory,
                                             MessageConverter messageConverter,
                                             @Qualifier("mailExchange") FanoutExchange mailExchange) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        template.setExchange(mailExchange.getName());
        return template;
    }
}
