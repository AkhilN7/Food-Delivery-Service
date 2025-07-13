package com.fds.OrderService.dao;

import com.fds.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    public Optional<List<Order>> findByUserId (int userId);
}
