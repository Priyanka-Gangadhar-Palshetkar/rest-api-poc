package com.almameal.api.poc.service;

import com.almameal.api.poc.model.Product;
import com.almameal.api.poc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;

@Service
public class ProductService {

    private final String ALMAMEAL = "Almameal";
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        if(Objects.isNull(product.getProductId())) {
            product.setCreatedBy(ALMAMEAL);
            product.setCreatedDate(new Date(System.currentTimeMillis()));
        } else {
            Product productInfo = productRepository.findById(product.getProductId()).orElse(null);
            if(Objects.nonNull(productInfo)) {
                product.setCreatedDate(productInfo.getCreatedDate());
                product.setCreatedBy(productInfo.getCreatedBy());
            }
            product.setUpdatedBy(ALMAMEAL);
            product.setUpdatedDate(new Date(System.currentTimeMillis()));
        }
        return productRepository.save(product);
    }

    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "SUCCESS";
    }
}
