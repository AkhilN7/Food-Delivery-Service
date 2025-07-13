package com.fds.DeliveryService.controller;

import com.fds.DeliveryService.model.Delivery;
import com.fds.DeliveryService.model.DeliveryBoy;
import com.fds.DeliveryService.model.DeliveryWrapper;
import com.fds.DeliveryService.model.OrderWrapper;
import com.fds.DeliveryService.service.DeliveryBoyService;
import com.fds.DeliveryService.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private DeliveryBoyService deliveryBoyService;
    //add delivery for the order
    @PostMapping("wedeliver")
    private ResponseEntity<String> addDelivery(OrderWrapper order){
        List<DeliveryBoy> dbois = deliveryService.getAllBois();
        DeliveryBoy db = deliveryService.pickDeliveryBoy(dbois);
        deliveryService.addDelivery(order,db);
        return new ResponseEntity<>("Sucessfully added", HttpStatus.OK);

    }

    //get delivery status -return delivery id and delivery boy name
    @GetMapping("status/{orderId}")
    public ResponseEntity<DeliveryWrapper> getStatus(@PathVariable int orderId){
        Delivery delivery = deliveryService.getById(orderId);
        DeliveryWrapper dw = new DeliveryWrapper(delivery.getOrderId(),delivery.getDeliveryStatus(),delivery.getDeliveryBoyId());
        return new ResponseEntity<>(dw,HttpStatus.OK);
    }

    //add delivery boy
    @PostMapping("addBoy")
    public ResponseEntity<String> addBoy(@RequestBody String name){
        DeliveryBoy deliveryBoy = new DeliveryBoy(name);
        deliveryBoyService.addDeliveryBoy(deliveryBoy);
        return new ResponseEntity<>("Successfully adde",HttpStatus.OK);

    }

    //update delivery status
    @PutMapping("/update")
    private ResponseEntity<String> updateStatus(@RequestBody String value,@RequestBody int deliveryId){
        Delivery delivery = deliveryService.getById(deliveryId);
        delivery.setDeliveryStatus(value);
        deliveryService.updateDelivery(delivery);
        return new ResponseEntity<>("Updated status",HttpStatus.OK);
    }


}
