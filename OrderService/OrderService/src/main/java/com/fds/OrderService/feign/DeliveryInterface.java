package com.fds.OrderService.feign;

import com.fds.OrderService.model.Order;
import com.fds.OrderService.model.OrderWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("DeliveryService")
public interface DeliveryInterface {

    @PostMapping("/delivery/wedeliver")
    public ResponseEntity<String> addDelivery(Order order);
}
