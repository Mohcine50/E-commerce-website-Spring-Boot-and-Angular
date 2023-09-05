package dev.shegami.profileservice.entities;

import dev.shegami.profileservice.models.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data @Table(name = "profiles")
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;


    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date modifiedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Address> shippingAddresses = new ArrayList<>();

    @Transient
    private Cart cart;

    private String cartId;

}
