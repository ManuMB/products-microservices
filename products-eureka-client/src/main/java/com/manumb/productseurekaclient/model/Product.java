package com.manumb.productseurekaclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private String instance;
}
