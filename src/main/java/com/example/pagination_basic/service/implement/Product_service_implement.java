package com.example.pagination_basic.service.implement;

import com.example.pagination_basic.entity.Product;
import com.example.pagination_basic.repository.Product_reporitory;
import com.example.pagination_basic.service.Product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Product_service_implement implements Product_service {
    @Autowired
    private Product_reporitory productReporitory;
    @Override
    public void init() {
        List<Product> products = IntStream.rangeClosed(1,200)
                .mapToObj(i->new Product("product"+i,new Random().nextInt(100),new Random().nextInt(5000)))
                .collect(Collectors.toList());
        productReporitory.saveAll(products);
    }

    @Override
    public List<Product> findall() {
        return productReporitory.findAll();
    }

    @Override
    public List<Product> findProductSorting(String field) {
        return productReporitory.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    @Override
    public Page<Product> pagination(int offset, int pageSize) {
        Page<Product> products =  productReporitory.findAll(PageRequest.of(offset,pageSize));
        return products;
    }

    @Override
    public Page<Product> paginationwithSorting(int offset, int pageSize, String field) {
        Page<Product> products = productReporitory.findAll(PageRequest.of(offset,pageSize,Sort.by(Sort.Direction.ASC,field)));
        return products;
    }
}
