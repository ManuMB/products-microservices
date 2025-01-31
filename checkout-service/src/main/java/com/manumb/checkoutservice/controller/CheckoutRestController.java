package com.manumb.checkoutservice.controller;

import com.manumb.checkoutservice.model.Checkout;
import com.manumb.checkoutservice.service.ICheckoutService;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutRestController {
    private ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }

    @GetMapping("/{id}")
    public Checkout getById(@PathVariable String id){
        return new Checkout(id);
    }

    @GetMapping()
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader("X-Request-From") String requestFrom, @RequestHeader() Map<String, String> headers) {
        System.out.println("Enviado desde: " + requestFrom);
        if(!requestFrom.equals("gateway")) {
            return null;
        }
        return checkoutService.buildCheckout(productIds);

    }
}
