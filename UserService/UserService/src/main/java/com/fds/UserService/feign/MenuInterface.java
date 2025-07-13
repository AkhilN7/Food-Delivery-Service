package com.fds.UserService.feign;


import com.fds.UserService.model.MenuWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("MenuService")
public interface MenuInterface {

    @GetMapping("/menu/name/{name}")
    public ResponseEntity<List<MenuWrapper>> getMenuByName(@PathVariable String name);

    @GetMapping("/menu/dish/{dish}/restaurant/{restaurantName}")
    public ResponseEntity<MenuWrapper> getMenuByDish(@PathVariable String dish,@RequestParam String restaurantName);

}
