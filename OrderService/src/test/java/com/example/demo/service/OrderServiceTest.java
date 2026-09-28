package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ng.order.entity.Order;
import com.ng.order.exception.ResourceNotFoundException;
import com.ng.order.repositroy.OrderRepository;
import com.ng.order.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	@Mock
	private OrderRepository orderRepo;
	
	@InjectMocks
	private OrderService orderService;
	
	@Test
	void getproductById_shouldReturnProduct() {
		Order order =new Order();
		order.setId(1L);
		
		
		when(orderRepo.findById(1L)).thenReturn(Optional.of(order));
		
		Order result=orderService.getOrderById(1L);
		assertEquals(1L,result.getId());
	}
	
	@Test
	void getOrderById_shouldThrowExceptionWhenNotFound() {
		when(orderRepo.findById(999L)).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class,()->orderService.getOrderById(999L));
		
	}
}

