package com.almameal.api.poc.controller;

import com.almameal.api.poc.model.Product;
import com.almameal.api.poc.service.ProductService;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        Iterable<Product> products = productService.getAllProducts();
        if(!Iterables.isEmpty(products)){
            return Lists.newArrayList(products);
        }

        return Collections.emptyList();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product newProduct) {
        return productService.createNewProduct(newProduct);
    }
}
