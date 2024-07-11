package com.manumb.checkoutservice.service.impl;

import com.manumb.checkoutservice.model.Checkout;
import com.manumb.checkoutservice.model.dto.Product;
import com.manumb.checkoutservice.service.ICheckoutService;
import com.manumb.checkoutservice.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CheckoutService implements ICheckoutService {

    private IProductService productService;

    //Hecho de manera ineficiente a proposito para que haga multiples request al endpoint, y asi utilizar el balanceador de carga.
    @Override
    public Checkout buildCheckout(List<String> productIds) {
        Double total = 0.0;
        for(String id :  productIds){
            Product product = productService.getProduct(id);
            System.out.println("Respuesta desde" + product.getInstance());
            total += product.getPrice();
        }
        Checkout checkout = new Checkout("234","www.digitalhouse.com/checkout?code=234",total.toString(),List.of("credit_card"));


        return checkout;
    }
}
