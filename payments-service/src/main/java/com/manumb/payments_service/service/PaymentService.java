package com.manumb.payments_service.service;

import com.manumb.payments_service.client.PaymentClient;
import com.manumb.payments_service.model.Payment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class PaymentService {
    private PublishNotification publishNotification;
    private PaymentClient paymentClient;

    public PaymentService(PublishNotification publishNotification, PaymentClient paymentClient) {
        this.publishNotification = publishNotification;
        this.paymentClient = paymentClient;
    }

    public void createPayment(Payment payment){
        //paymentClient llama al metodo createPayment donde simulamos un pago exitoso
        paymentClient.createPayment(payment);
        //aca enviamos el id del cliente que realiza el pago al topico correspondiente de rabbitmq
        publishNotification.sendMessageToTopic(payment.getClientId());
    }
}
