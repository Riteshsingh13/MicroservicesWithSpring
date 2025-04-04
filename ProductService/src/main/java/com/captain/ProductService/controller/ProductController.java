package com.captain.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captain.ProductService.model.ProductRequest;
import com.captain.ProductService.model.ProductResponse;
import com.captain.ProductService.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
		long productId = productService.addproduct(productRequest);
		
		return new ResponseEntity<>(productId, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
		ProductResponse productResponse = productService.getProductById(productId);
		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
	}

}
