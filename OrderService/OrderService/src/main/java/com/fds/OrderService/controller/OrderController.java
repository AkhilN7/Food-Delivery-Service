package com.fds.OrderService.controller;

import com.fds.OrderService.feign.DeliveryInterface;
import com.fds.OrderService.model.Order;
import com.fds.OrderService.model.OrderWrapper;
import com.fds.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DeliveryInterface deliveryInterface;
    //add an order
    @PostMapping("addOrder")
    public ResponseEntity<String> addOrder(@RequestBody OrderWrapper orderw) {
        //orderService.addOrder(order);
        Order order = new Order(orderw.getUser_id(),orderw.getUserAdress(),orderw.getDishName(),orderw.getHotelName(),
                orderw.getPrice(),orderw.getStatus());
        //call the delivery service
        deliveryInterface.addDelivery(order);
        orderService.addOrder(orderw);
        return new ResponseEntity<>("Order added", HttpStatus.OK);
    }

    //get your order - as per order id
    @GetMapping("getOrder/{orderid}")
    private ResponseEntity<Optional<Order>> getOrderById(@PathVariable int orderid){
        Optional<Order> order = orderService.getOrderById(orderid);
        if(order.equals(null))
            return new ResponseEntity<>(order,HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(order,HttpStatus.OK);
    }

    //get all your orders -  as per user id
    @GetMapping("getAllOrders/{userId}")
    private ResponseEntity<Optional<List<Order>>> getOrders(@PathVariable int userId){
        Optional<List<Order>> order = orderService.grtOrders(userId);
        if(order.equals(null))
            return new ResponseEntity<>(order,HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(order,HttpStatus.OK);

    }

}
