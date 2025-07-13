package com.fds.MenuService.model;


public class MenuWrapper {

    private int restaurant_id;
    private String dish_name;
    private String restaurant_name;
    private String category;
    private int price;

    public MenuWrapper(int restaurant_id,String dish_name, String restaurant_name, String category, int price) {
        this.restaurant_id = restaurant_id;
        this.dish_name = dish_name;
        this.restaurant_name = restaurant_name;
        this.category = category;
        this.price = price;
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


}
