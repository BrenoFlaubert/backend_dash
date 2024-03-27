package com.example.dashboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dashboard.model.Product;
import com.example.dashboard.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Iterable<Product> getMethodName() {
        return repository.findAll();
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            @SuppressWarnings("null")
            Product savedProduct = repository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            throw new ProductCreationException("Falha ao criar produto.", e);
        }
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    class ProductCreationException extends RuntimeException {
        public ProductCreationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
}
