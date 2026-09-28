package com.ng.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ng.order.client.ProductClient;
import com.ng.order.dto.ProductResponse;
import com.ng.order.entity.Order;
import com.ng.order.exception.ResourceNotFoundException;
import com.ng.order.repositroy.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepo;
	private final ProductClient productClient;
	
	public OrderService(OrderRepository orderRepo, ProductClient productClient) {
		
		this.orderRepo = orderRepo;
		this.productClient = productClient;
	}
	
	
	public Order createOrder(Order order) {
		ProductResponse product=productClient.getProduct(order.getProductId());
		if(product.getQuantity()<order.getQuantity()) {
			throw new ResourceNotFoundException("Insufficient Product Quantity");
		}
		
		double total=product.getPrice()*order.getQuantity();
		order.setTotalPrice(total);
		
		order.setStatus("CREATED");
		
		return orderRepo.save(order);
	}
	
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}

	public Order getOrderById(Long id) {
		return orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("order not found with id"+id));
	}
	
	
}
