package com.github.flaviolehmann.tarefax.service.queue;

import com.github.flaviolehmann.tarefax.service.dto.MailDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${application.rabbitmq.queues.mail-queue}"})
    public void receive(@Payload MailDTO mailDTO) {
        System.out.println("Mensagem recebida: " + mailDTO.toString());
    }
}
