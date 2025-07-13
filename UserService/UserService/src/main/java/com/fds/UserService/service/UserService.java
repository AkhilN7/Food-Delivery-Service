package com.fds.UserService.service;

import com.fds.UserService.dao.UserRepo;
import com.fds.UserService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void registerUser(User user) {
        userRepo.save(user);
    }
}
