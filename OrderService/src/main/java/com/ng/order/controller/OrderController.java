
package com.ng.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ng.order.entity.Order;
import com.ng.order.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		
		this.orderService = orderService;
	}
	
	
	@PostMapping
	public Order createOrder(@Valid @RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@GetMapping()
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
				
	}
	
	@GetMapping("{id}")
	public Order deleteOrder(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
}
