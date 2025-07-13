package com.fds.MenuService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int restaurant_id;
    private String dish_name;
    private String restaurant_name;
    private String category;
    private int price;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu(int id, int restaurant_id, String dish_name, String restaurant_name, String category, int price, String description) {
        this.id = id;
        this.restaurant_id = restaurant_id;
        this.dish_name = dish_name;
        this.restaurant_name = restaurant_name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Menu(MenuWrapper menu){
        this.restaurant_id = menu.getRestaurant_id();
        this.dish_name = menu.getDish_name();
        this.restaurant_name  = menu.getRestaurant_name();
        this.category = menu.getCategory();
        this.price = menu.getPrice();

    }

}
