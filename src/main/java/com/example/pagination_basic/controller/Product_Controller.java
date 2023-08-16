package com.example.pagination_basic.controller;
import com.example.pagination_basic.entity.Product;
import com.example.pagination_basic.service.Product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Product_Controller {
    @Autowired
    private Product_service productService;
    @PostMapping("/init")
    public void init(){
        productService.init();
    }
    @GetMapping(value = "/getalldata")
    public ResponseEntity<List<Product>> getallproduct(){
        return new ResponseEntity<List<Product>>((List<Product>) productService.findall(), HttpStatus.OK);
    }
    @GetMapping(value = "/{field}")
    public ResponseEntity<List<Product>> getallproductBySorting(@PathVariable(name = "field") String field){
        return new ResponseEntity<List<Product>>(productService.findProductSorting(field),HttpStatus.OK);
    }
    @GetMapping(value = "/pagination/{offset}/{pagesize}")
    public ResponseEntity<Page<Product>> getProductByPagination(@PathVariable(name = "offset") int offset,@PathVariable(name = "pagesize") int pagesize){
        return new ResponseEntity<Page<Product>>(productService.pagination(offset,pagesize),HttpStatus.OK);
    }
    @GetMapping(value = "/paginationAndsorting/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Product>> getProductByPaginationAndSorting(
            @PathVariable(name = "offset") int offset,
            @PathVariable(name = "pagesize") int pagesize,
            @PathVariable(name = "field") String field
    ){
        return new ResponseEntity<>(productService.paginationwithSorting(offset,pagesize,field),HttpStatus.OK);
    }
}
