package com.fds.OrderService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int orderId;
    private int userId;
    private String userAdress;
    private String dishName;
    private String hotelName;
    private int price;
    private char status;

    public Order(int orderId,int userId,String userAdress,String hotelName){
        this.orderId = orderId;
        this.userId = userId;
        this.userAdress = userAdress;
        this.hotelName = hotelName;
    }

    public Order(int userId,String userAdress,String dishName,String hotelName,int price,char staus){
        this.userId = userId;
        this.userAdress = userAdress;
        this.dishName = dishName;
        this.hotelName = hotelName;
        this.price = price;
        this.status = staus;
    }

    public Order(OrderWrapper order){
        this.userId = order.getUser_id();
        this.userAdress = order.getUserAdress();
        this.dishName = order.getDishName();
        this.hotelName = order.getHotelName();
        this.price = order.getPrice();
        this.status = order.getStatus();
    }


}
