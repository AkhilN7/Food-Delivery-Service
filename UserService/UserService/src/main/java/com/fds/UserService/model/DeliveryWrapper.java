package com.fds.UserService.model;

public class DeliveryWrapper {

    private int orderId;
    private String deliveryStatus;
    private int deliveryBoyId;

    public DeliveryWrapper(int orderId, String deliveryStatus, int deliveryBoyId) {
        this.orderId = orderId;
        this.deliveryStatus = deliveryStatus;
        this.deliveryBoyId = deliveryBoyId;
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
