package com.example.pagination_basic.repository;

import com.example.pagination_basic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_reporitory extends JpaRepository<Product,Long> {
}
