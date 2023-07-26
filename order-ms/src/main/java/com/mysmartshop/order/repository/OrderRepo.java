package com.mysmartshop.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mysmartshop.order.model.Order;

public interface OrderRepo extends MongoRepository<Order,Integer> {
	public Order findByOrderId(String OrderId);
}
