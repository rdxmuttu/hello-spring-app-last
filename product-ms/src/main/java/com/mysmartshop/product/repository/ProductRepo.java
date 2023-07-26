package com.mysmartshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mysmartshop.product.model.Product;

public interface  ProductRepo extends JpaRepository<Product,String> {

}
