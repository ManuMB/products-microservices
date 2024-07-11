package com.manumb.payments_service.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
//@NoArgsConstructor
public class PublishNotification {
    //declaramos a rabbit
    private RabbitTemplate rabbitTemplate;

    public PublishNotification(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //este metodo toma un mensaje y lo envia al topico indicado
    public void sendMessageToTopic(String message){
        rabbitTemplate.convertAndSend("send-notification", message);
    }
}
