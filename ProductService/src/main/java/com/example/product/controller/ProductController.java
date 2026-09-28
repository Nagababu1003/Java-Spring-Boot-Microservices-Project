package com.example.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping("/test")
	public String test(){
		return "Product Controller Working";
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@Valid @RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("{id}")
	public Product getProduct(@PathVariable Long id) { 
		return productService.getProductById(id);
	}
	
	@PutMapping("{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
}
