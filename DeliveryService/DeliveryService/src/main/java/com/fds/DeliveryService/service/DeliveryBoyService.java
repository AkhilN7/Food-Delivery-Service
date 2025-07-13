package com.fds.DeliveryService.service;

import com.fds.DeliveryService.dao.DeliveryBoyRepo;
import com.fds.DeliveryService.model.DeliveryBoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryBoyService {

    @Autowired
    private DeliveryBoyRepo deliveryBoyRepo;

    public void addDeliveryBoy(DeliveryBoy db){
        deliveryBoyRepo.save(db);
    }

}
