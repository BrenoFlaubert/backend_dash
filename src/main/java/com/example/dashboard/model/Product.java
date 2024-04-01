package com.example.dashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String condition;
    private int quantityPurchased;
    private int soldAmount;
    private int quantityInStock;
    public Product() {
    }
    public Product(Long id, String name, int price, String condition, int quantityPurchased, int soldAmount, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.condition = condition;
        this.quantityPurchased = quantityPurchased;
        this.soldAmount = soldAmount;
        this.quantityInStock = quantityInStock;
    }
    
}
