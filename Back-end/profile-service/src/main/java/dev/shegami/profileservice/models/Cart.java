package dev.shegami.profileservice.models;

import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class Cart {
    private String id;
    private Float total;
    private Date createdAt;
    private Date modifiedAt;
    Collection<CartItem> items;

}
