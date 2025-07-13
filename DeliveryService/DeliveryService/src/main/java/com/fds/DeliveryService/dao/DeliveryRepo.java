package com.fds.DeliveryService.dao;

import com.fds.DeliveryService.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery,Integer> {

   @Query("Update Delivery d set d.deliveryStatus = ?2 where d.deliveryId = ?1")
    public void updateById(int deliveryId, String deliveryStatus);

   @Query("Select d from Delivery d where d.orderId = ?1")
   public Delivery findByOrderId(int orderId);
}
