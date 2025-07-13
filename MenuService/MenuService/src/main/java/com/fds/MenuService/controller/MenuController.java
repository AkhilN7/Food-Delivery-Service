package com.fds.MenuService.controller;

import com.fds.MenuService.model.Menu;
import com.fds.MenuService.model.MenuWrapper;
import com.fds.MenuService.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    //add dish
    @PostMapping("addDish")
    public ResponseEntity<String> addDish(@RequestBody Menu menu) {
        menuService.addDish(menu);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


    //get dish by name
    @GetMapping("name/{name}")
    public ResponseEntity<List<MenuWrapper>>getMenuByName(@PathVariable String name) {
        List<Menu> menus = menuService.findByName(name);
        List<MenuWrapper> menusWrapper = new ArrayList<>();
        for(Menu m: menus){
            MenuWrapper mw = new MenuWrapper(m.getRestaurant_id(),m.getDish_name(),
                    m.getRestaurant_name(),m.getCategory(),m.getPrice());
            menusWrapper.add(mw);
        }
        return new ResponseEntity<>(menusWrapper, HttpStatus.OK);
    }

    //get dish by category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Menu>> getMenuByCategory(@PathVariable String category) {
        List<Menu> menus = menuService.findByCategory(category);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    //get dish by restayurant
    @GetMapping("/dish/{dish}/restaurant/{restaurantName}")
    public ResponseEntity<MenuWrapper> getMenuByDish(@PathVariable String dish,@RequestParam String restaurantName) {
        Menu menu = menuService.findByDishNameAndRestaurantName(dish,restaurantName);
        MenuWrapper mw = new MenuWrapper(menu.getRestaurant_id(),menu.getDish_name(),
                menu.getRestaurant_name(),menu.getCategory(),menu.getPrice());
        return new ResponseEntity<>(mw, HttpStatus.OK);
    }
    //get dish by price less than
    @GetMapping("priceLsss")
    public ResponseEntity<List<Menu>> getMenuByPrice(@RequestParam double price) {
        List<Menu> menus= menuService.findByLessThanPrice(price);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }
    //get dish by price upper than
    @GetMapping("priceMore")
    public  ResponseEntity<List<Menu>> getMenuByPriceUpper(@RequestParam double price) {
        List<Menu> menus= menuService.findByMoreThanPrice(price);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }
}
