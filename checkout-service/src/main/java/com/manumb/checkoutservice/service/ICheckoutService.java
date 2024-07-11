package com.manumb.checkoutservice.service;

import com.manumb.checkoutservice.model.Checkout;

import java.util.List;

public interface ICheckoutService {
    public Checkout buildCheckout(List<String> productIds);
}
