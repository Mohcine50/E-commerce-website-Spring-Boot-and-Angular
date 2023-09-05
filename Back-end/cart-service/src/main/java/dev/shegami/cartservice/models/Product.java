package dev.shegami.cartservice.models;

import jakarta.persistence.Column;

import java.util.Date;

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
