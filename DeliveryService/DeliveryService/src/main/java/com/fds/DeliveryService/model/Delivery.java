package com.fds.DeliveryService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int deliveryId;
    private int orderId;
    private String deliveryStatus;
    private int deliveryBoyId;

    public Delivery(int orderId,String deliveryStatus, int deliveryBoyId){
        this.orderId = orderId;
        this.deliveryStatus = deliveryStatus;
        this.deliveryBoyId  = deliveryBoyId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getDeliveryBoyId() {
        return deliveryBoyId;
    }

    public void setDeliveryBoyId(int deliveryBoyId) {
        this.deliveryBoyId = deliveryBoyId;
    }
}
