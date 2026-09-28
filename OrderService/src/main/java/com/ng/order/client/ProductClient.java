package com.ng.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ng.order.dto.ProductResponse;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductClient {
	
	@GetMapping("/products/{id}")
	ProductResponse getProduct(@PathVariable("id") Long id);
}
