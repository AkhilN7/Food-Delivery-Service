package com.fds.UserService.feign;

import com.fds.UserService.model.DeliveryWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DeliveryService")
public interface DeliveryInterface {

    @GetMapping("/delivery/status/{orderId}")
    public  ResponseEntity<DeliveryWrapper> getStatus(@PathVariable int orderId);
}
