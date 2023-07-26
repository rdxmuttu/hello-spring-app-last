package com.mysmartshop.order.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mysmartshop.order.model.CartItem;
import com.mysmartshop.order.model.Order;
import com.mysmartshop.order.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo repo;
	
	@Override
	public Order getOrderDetails(String orderId) {
		return repo.findByOrderId(orderId);
	}
	
//	@Override
//	public Order placeOrder(List<CartItem> cartItems) {
//		Order orderDetails = new Order();
//		orderDetails.setOrderItems(cartItems);
//		orderDetails.setStatus("Order Placed");
//		
//		
//		Random rnd = new Random(100000);
//		
//		
//		String str = "n"+System.currentTimeMillis()+Math.abs(rnd.nextLong());
//		orderDetails.set_id(Math.abs(rnd.nextInt()));
//		orderDetails.setOrderId(str);
//		return repo.save(orderDetails);
//	}@Override
    public Order placeOrder(List<CartItem> cartItems) {
        Order orderDetails = new Order();
        orderDetails.setOrderItems(cartItems);
        orderDetails.setStatus("Order Placed");
        Random rnd = new Random();
        int num = rnd.nextInt(900000)+100000;
        String str = "n"+System.currentTimeMillis()+num;
        orderDetails.set_id(num);
        orderDetails.setOrderId(str);
        return repo.save(orderDetails);
    }


	@Override
    public void cancelOrder(String orderId) {
        Order order=getOrderDetails(orderId);
        repo.deleteById(order.get_id());
    }

 

    @Override
    public List<Order> getAllOrders(){
        return repo.findAll();
    }

 

    @Override
    public void updateOrderDetails(String orderId, String status) {
        Order order= getOrderDetails(orderId);
        order.setOrderId(orderId);
        order.setStatus(status);
        repo.save(order);
    }

}
