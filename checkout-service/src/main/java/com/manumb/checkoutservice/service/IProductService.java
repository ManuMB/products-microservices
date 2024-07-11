package com.manumb.checkoutservice.service;

import com.manumb.checkoutservice.model.dto.Product;

public interface IProductService {
    public Product getProduct(String id);
}
