package com.fds.MenuService.dao;

import com.fds.MenuService.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.dish_name = ?1")
    public List<Menu> findByName(String name) ;

    @Query("SELECT m FROM Menu m WHERE m.category = ?1")
    public List<Menu> findByCategory(String category);

    @Query("SELECT m FROM Menu m WHERE m.dish_name = ?1 AND m.restaurant_name = ?2")
    public Menu findByDishNameAndRestaurantName(String dish, String restaurantName);

    @Query("SELECT m FROM Menu m WHERE m.price < ?1")
    public List<Menu> findByLessThanPrice(double price);

    @Query("SELECT m FROM Menu m WHERE m.price > ?1")
    public List<Menu> findByMoreThanPrice(double price);
}
