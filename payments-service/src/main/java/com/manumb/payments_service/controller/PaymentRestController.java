package com.manumb.payments_service.controller;

import com.manumb.payments_service.model.Payment;
import com.manumb.payments_service.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payments")
@RestController
//@AllArgsConstructor
//@NoArgsConstructor
public class PaymentRestController {

    private PaymentService paymentService;

    Logger log = LoggerFactory.getLogger(PaymentRestController.class);

    public PaymentRestController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }

    @PostMapping()
    public void createPayment(@RequestBody Payment payment){
        paymentService.createPayment(payment);
    }

    @GetMapping()
    public Payment getPayment(String id) {
        log.info("Intentando obtener payment con id: "+id +".....");

        /// utilizar un servicio

        log.error("Error al intentar obtener un payment");

        return new Payment(id, 400.0f,"id 1", "id 2");

    }
}
