package com.example.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.exception.ResourceNotFoundException;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
	
	  
	  private final ProductRepository productRepo;
	  
	  public ProductService(ProductRepository productRepo){
		  this.productRepo =productRepo; 
	  }
	  
	  public Product createProduct(Product product){ 
		  return productRepo.save(product); 
	  }
	  
	  public List<Product> getAllProducts(){ 
		  return productRepo.findAll(); 
	  }
	  
	  public Product getProductById(Long id) { 
		  return productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found with id:"+id)); 
	  }
	  
	  
	  public Product updateProduct(Long id,Product product) { 
		  Product existing=getProductById(id); 
		  existing.setName(product.getName());
		  existing.setPrice(product.getPrice());
		  existing.setQuantity(product.getQuantity()); 
		  return productRepo.save(existing); 
	  }
	  
	  public void deleteProduct(Long id) 
	  { 
		  Product product=getProductById(id); 
		  productRepo.delete(product); 
	  }
	 
}
