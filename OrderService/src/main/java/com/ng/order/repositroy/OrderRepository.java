package com.ng.order.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ng.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
