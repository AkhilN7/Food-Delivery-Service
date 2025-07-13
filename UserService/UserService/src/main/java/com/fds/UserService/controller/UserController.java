package com.fds.UserService.controller;


import com.fds.UserService.feign.DeliveryInterface;
import com.fds.UserService.feign.MenuInterface;
import com.fds.UserService.feign.UserInterface;
import com.fds.UserService.model.DeliveryWrapper;
import com.fds.UserService.model.MenuWrapper;
import com.fds.UserService.model.OrderWrapper;
import com.fds.UserService.model.User;
import com.fds.UserService.service.JwtService;
import com.fds.UserService.service.UserService;

import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserInterface userInterface;

    @Autowired
    private MenuInterface menuInterface;

    @Autowired
    private DeliveryInterface deliveryInterface;
    //register account
    @PostMapping("register")
    private ResponseEntity<String> registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.registerUser(user);
        return new ResponseEntity<>("User Registered", HttpStatus.OK);

    }

    //login
    @PostMapping("login")
    private ResponseEntity<String> login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        if(authentication.isAuthenticated()){
            System.out.println(jwtService.generateToken(user.getUsername()));
            return new ResponseEntity<>(jwtService.generateToken(user.getUsername()),HttpStatus.OK);
        }
        return new ResponseEntity<>("login failed",HttpStatus.OK);
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    //get menu By Restaurant and dish name
    @GetMapping("/dish/{dish}/restaurant/{restaurantName}")
    public ResponseEntity<MenuWrapper> getMenuByHotel(@PathVariable String dish,@PathVariable String restaurantName){
        MenuWrapper mw = menuInterface.getMenuByDish(dish,restaurantName).getBody();
        return new ResponseEntity<>(mw,HttpStatus.OK);
    }

    //get menu by dish_name
    @GetMapping("menubydish/{dish}")
    public ResponseEntity<List<MenuWrapper>> getMenuByDish(@PathVariable String dish){
        List<MenuWrapper> mw = menuInterface.getMenuByName(dish).getBody();
        return new ResponseEntity<>(mw,HttpStatus.OK);

    }


    //place an order
    @PostMapping("placeorder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderWrapper order){
        userInterface.addOrder(order);
        return new ResponseEntity<>("Order Placed",HttpStatus.OK);
    }

    //get delivery info
    @GetMapping("deliveryinfo/{orderId}")
    public ResponseEntity<DeliveryWrapper> deliveryInfo(@PathVariable int orderId){
        DeliveryWrapper dw  = deliveryInterface.getStatus(orderId).getBody();
        return new ResponseEntity<>(dw,HttpStatus.OK);

    }





}
