package com.fds.OrderService.service;

import com.fds.OrderService.dao.OrderRepo;
import com.fds.OrderService.model.Order;
import com.fds.OrderService.model.OrderWrapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    public void addOrder(OrderWrapper order) {
        orderRepo.save((new Order(order)));
    }

    public Optional<Order> getOrderById(int orderid) {
        Optional<Order> order = orderRepo.findById(orderid);
        if(order.equals(null)){
            return null;
        }
        else
            return order;
    }


    public Optional<List<Order>> grtOrders(int userId) {
        Optional<List<Order>> orders = orderRepo.findByUserId(userId);
        return orders;
    }
}
