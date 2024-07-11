package com.manumb.payments_service.client;

import com.manumb.payments_service.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentClient {

    //esta clase y metodo simula un llamado a un servicio/cliente externo para ejecutar el pago. Devolvemos true como que el pago se ejecuto ok.
    public Boolean createPayment(Payment payment){
        return true;
    }
}
