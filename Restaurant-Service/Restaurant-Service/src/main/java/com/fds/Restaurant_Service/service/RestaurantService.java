package com.fds.Restaurant_Service.service;

import com.fds.Restaurant_Service.dao.RestaurantRepo;
import com.fds.Restaurant_Service.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;
    public void addRestaurant(Restaurant r) {
        restaurantRepo.save(r);

    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurantRepo.findByName(name);
    }
}
