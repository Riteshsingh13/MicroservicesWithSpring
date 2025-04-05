package com.captain.ProductService.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captain.ProductService.entity.Product;
import com.captain.ProductService.exception.ProductServiceCustomException;
import com.captain.ProductService.model.ProductRequest;
import com.captain.ProductService.model.ProductResponse;
import com.captain.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addproduct(ProductRequest productRequest) {
		log.info("Adding product...");
		
		Product product = Product.builder()
				.productName(productRequest.getName())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity())
				.build();
		
		productRepository.save(product);
		log.info("Product added..");
		
		return product.getProductID();
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info("Getting product by ID: "+ productId);
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceCustomException("Product is not available with given id", "PRODUCT_NOT_FOUND"));
		
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		return productResponse;
	}

}
