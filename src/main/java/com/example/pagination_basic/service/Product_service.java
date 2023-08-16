package com.example.pagination_basic.service;

import com.example.pagination_basic.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Product_service {
    @PostConstruct
    public void init();
    public List<Product> findall ();
    public List<Product> findProductSorting(String field);
    public Page<Product> pagination(int offset,int pageSize);
    public Page<Product> paginationwithSorting(int offset,int pageSize, String field);
}
