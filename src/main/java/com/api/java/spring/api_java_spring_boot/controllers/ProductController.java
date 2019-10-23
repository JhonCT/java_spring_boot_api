package com.api.java.spring.api_java_spring_boot.controllers;

import com.api.java.spring.api_java_spring_boot.models.Product;
import com.api.java.spring.api_java_spring_boot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/", produces = "application/json")
    public String save(Product product) {
        return productService.save(product);
    }

    @PutMapping(value = "/", produces = "application/json")
    public String update(Product product) {
        return productService.update(product);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Product> all() {
        return productService.all();
    }
}
