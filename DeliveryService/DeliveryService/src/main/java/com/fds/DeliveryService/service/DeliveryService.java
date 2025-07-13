package com.fds.DeliveryService.service;

import com.fds.DeliveryService.dao.DeliveryBoyRepo;
import com.fds.DeliveryService.dao.DeliveryRepo;
import com.fds.DeliveryService.model.Delivery;
import com.fds.DeliveryService.model.DeliveryBoy;
import com.fds.DeliveryService.model.OrderWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepo deliveryRepo;

    @Autowired
    private DeliveryBoyRepo deliveryBoyRepo;

    public List<DeliveryBoy> getAllBois(){
        List<DeliveryBoy> bois =  deliveryBoyRepo.findAll();
        return bois;
    }

    public DeliveryBoy pickDeliveryBoy(List<DeliveryBoy> list){
        int randomNum = (int)(Math.random() * list.size());
        DeliveryBoy db = list.get(randomNum);
        return db;
    }

    public void addDelivery(OrderWrapper order, DeliveryBoy db) {
        Delivery delivery = new Delivery(order.getOrder_id(),"N",db.getDbId());
        deliveryRepo.save(delivery);
    }

    public Delivery getById(int deliveryId) {
         if(deliveryRepo.findByOrderId(deliveryId).equals(null)){
             return null;
        }
        return deliveryRepo.findById(deliveryId).get();
    }

    public void updateDelivery(Delivery delivery) {
        deliveryRepo.updateById(delivery.getDeliveryId(),delivery.getDeliveryStatus());

    }
}
