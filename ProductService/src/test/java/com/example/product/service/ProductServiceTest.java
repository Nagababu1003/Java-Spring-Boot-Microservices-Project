package com.example.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.product.entity.Product;
import com.example.product.exception.ResourceNotFoundException;
import com.example.product.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepo;
	
	@InjectMocks
	private ProductService productService;
	
	@Test
	void getproductById_shouldReturnProduct() {
		Product product =new Product();
		product.setId(1L);
		product.setName("Laptop");
		product.setPrice(50000.0);
		
		when(productRepo.findById(1L)).thenReturn(Optional.of(product));
		
		Product result=productService.getProductById(1L);
		assertEquals(1L,result.getId());
		assertEquals("Laptop",result.getName());
		assertEquals(50000.0,result.getPrice());
	}
	
	@Test
	void getProductById_shouldThrowExceptionWhenProductNotFound() {
		when(productRepo.findById(999L)).thenReturn(Optional.empty());
		ResourceNotFoundException exception=assertThrows(ResourceNotFoundException.class,()->productService.getProductById(999L));
		assertEquals("Product not found with id:999",exception.getMessage());
	}
}
