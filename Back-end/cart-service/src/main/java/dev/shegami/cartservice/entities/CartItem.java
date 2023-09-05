package dev.shegami.cartservice.entities;

import dev.shegami.cartservice.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cartItems")
@Entity
public class CartItem {

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
