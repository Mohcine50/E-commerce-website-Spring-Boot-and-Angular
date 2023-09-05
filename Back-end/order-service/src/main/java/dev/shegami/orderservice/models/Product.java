package dev.shegami.orderservice.models;

import jakarta.persistence.Column;

public class Product {

    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String SKU;
    @Column(nullable = false)
    private Float price;
}
