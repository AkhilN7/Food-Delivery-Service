package com.fds.Restaurant_Service.controller;

import com.fds.Restaurant_Service.model.Restaurant;
import com.fds.Restaurant_Service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurants")
public class JavaController {

    @Autowired
    private RestaurantService restaurantService;

    //add Restaurant
    @PostMapping("addrestaurant")
    private ResponseEntity<String> addRestaurant(@RequestBody Restaurant r) {
        restaurantService.addRestaurant(r);
        return new ResponseEntity<>("Successfully added restaurant", HttpStatus.CREATED);
    }

    //Get All restaurants

    @GetMapping("allrestaunrants")
    private ResponseEntity<List<Restaurant>> getAllRestaurants() {

        return new ResponseEntity<>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping("restaurant/{name}")
    private ResponseEntity<Restaurant> getRestaurantByName(@PathVariable String name) {
        System.out.println(restaurantService.getRestaurantByName(name));
        return new ResponseEntity<>(restaurantService.getRestaurantByName(name),HttpStatus.OK);
    }
}
