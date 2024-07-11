package com.manumb.notifications_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//Esta clase escucha y recibe cuando enviamos pagos exitosos al topico desde payments-service
@Service
public class NotificationConsumer {
    Logger log = LoggerFactory.getLogger(NotificationConsumer.class);

    @RabbitListener(queues="send-notification")
    public void consume(String message){
        log.info("Recibiendo mensaje del tópico send-notification: " + message);    //El mensaje seria el id del cliente comprador
    }
}
