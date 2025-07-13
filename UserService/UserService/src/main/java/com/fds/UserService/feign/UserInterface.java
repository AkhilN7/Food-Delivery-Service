package com.fds.UserService.feign;


import com.fds.UserService.model.OrderWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("OrderService")
public interface UserInterface {

    @PostMapping("/order/addOrder")
    public ResponseEntity<String> addOrder(@RequestBody OrderWrapper order);
}
