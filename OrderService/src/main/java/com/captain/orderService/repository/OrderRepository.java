package com.captain.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.captain.orderService.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
