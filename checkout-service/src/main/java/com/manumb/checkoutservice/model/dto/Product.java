package com.manumb.checkoutservice.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    private String id;
    private String name;
    private double price;
    private String instance;
}
