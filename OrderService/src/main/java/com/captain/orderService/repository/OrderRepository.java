package com.captain.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.captain.orderService.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
