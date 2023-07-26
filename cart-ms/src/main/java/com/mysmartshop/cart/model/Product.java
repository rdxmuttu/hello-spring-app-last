package com.mysmartshop.cart.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {

	private String productId;
	private String name;
	private float price;
	private String description;
}
