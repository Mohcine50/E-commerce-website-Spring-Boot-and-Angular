package dev.shegami.orderservice.entities;

import dev.shegami.orderservice.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@Table(name = "orderItems")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private int quantity;
    @Transient
    private Product product;
    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private Date modifiedAt;
}
