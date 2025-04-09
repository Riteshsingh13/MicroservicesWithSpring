package com.captain.orderService.service;

import com.captain.orderService.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

}
