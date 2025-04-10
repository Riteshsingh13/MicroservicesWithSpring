package com.captain.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captain.orderService.model.OrderRequest;
import com.captain.orderService.service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/v1/order")
@Log4j2
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
		log.info("Saving order details...");
		long orderID = orderService.placeOrder(orderRequest);
		log.info("Place order with ID: "+orderID);
		return new ResponseEntity<>(orderID, HttpStatus.OK);
	}

}
