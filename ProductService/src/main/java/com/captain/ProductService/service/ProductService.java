package com.captain.ProductService.service;

import com.captain.ProductService.model.ProductRequest;
import com.captain.ProductService.model.ProductResponse;

public interface ProductService {

	long addproduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void reduceQuantity(long productId, long quantity);

}
