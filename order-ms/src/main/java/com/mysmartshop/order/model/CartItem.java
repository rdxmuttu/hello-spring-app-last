package com.mysmartshop.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@AllArgsConstructor
//@NoArgsConstructor
@Data
//@Entity
public class CartItem {
	//@Id
	//@GeneratedValue
	private int cartId;
	private String productId;
	private int quantity;
	private float totalPrice;
}
