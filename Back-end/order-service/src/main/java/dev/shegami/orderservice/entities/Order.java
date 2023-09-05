package dev.shegami.orderservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Builder
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private Float total;
    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private Date modifiedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    Collection<OrderItem> items;
}
