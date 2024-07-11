package com.manumb.checkoutservice.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Checkout {
    private String id;
    private String url;
    private String totalAmount;
    private List<String> availableMethods;

    public Checkout(String id) {
        this.id = id;
    }
}
