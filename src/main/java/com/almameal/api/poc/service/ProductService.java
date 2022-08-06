package com.almameal.api.poc.service;

import com.almameal.api.poc.model.Product;
import com.almameal.api.poc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }
}
