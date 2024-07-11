package com.manumb.payments_service.model;

public class Payment {
    private String id;
    private Float amount;
    private String clientId;    //id del cliente que compra el producto
    private String ownerId;     //id del vendedor del producto

    public Payment(String id, Float amount, String clientId, String ownerId) {
        this.id = id;
        this.amount = amount;
        this.clientId = clientId;
        this.ownerId = ownerId;
    }

    public Payment() {
    }

    public String getId() {
        return this.id;
    }

    public Float getAmount() {
        return this.amount;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
