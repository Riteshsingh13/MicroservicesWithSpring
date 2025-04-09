package com.captain.orderService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captain.orderService.entity.Order;
import com.captain.orderService.model.OrderRequest;
import com.captain.orderService.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public long placeOrder(OrderRequest orderRequest) {
		log.info("Saving order details in orderdb: " + orderRequest);
		Order order = Order.builder()
				.amount(orderRequest.getTotalAmount())
				.productID(orderRequest.getProductId())
				.quantity(orderRequest.getQuantity())
				.orderStatus("CREATED")
				.orderDate(Instant.now())
				.build();
		order = orderRepository.save(order);
		log.info("Order placed and the order id is: " + order.getOrderID());
		return order.getOrderID();
	}

}
