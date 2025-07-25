package com.captain.orderService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ProductService/v1/product")
public interface ProductService {
	@PutMapping("/reduceQuantity/{id}")
	ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity);
}
