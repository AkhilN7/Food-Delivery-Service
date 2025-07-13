package com.fds.MenuService.service;

import com.fds.MenuService.dao.MenuRepo;
import com.fds.MenuService.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepo menuRepo;

    public void addDish(Menu menu) {
        menuRepo.save(menu);
    }

    public List<Menu> findByName(String name) {
        return menuRepo.findByName(name);
    }

    public List<Menu> findByCategory(String category) {
        return menuRepo.findByCategory(category);
    }

    public Menu findByDishNameAndRestaurantName(String dish, String restaurantName) {
        return menuRepo.findByDishNameAndRestaurantName(dish,restaurantName);
    }

    public List<Menu> findByLessThanPrice(double price) {
        return menuRepo.findByLessThanPrice(price);
    }

    public List<Menu> findByMoreThanPrice(double price) {
        return menuRepo.findByMoreThanPrice(price);
    }
}
