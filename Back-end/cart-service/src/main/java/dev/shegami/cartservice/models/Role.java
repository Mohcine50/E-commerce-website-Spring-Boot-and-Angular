package dev.shegami.cartservice.models;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Role {
    private String id;
    private String name;
}
