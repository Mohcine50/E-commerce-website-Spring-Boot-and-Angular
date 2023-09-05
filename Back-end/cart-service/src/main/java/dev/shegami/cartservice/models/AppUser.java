package dev.shegami.cartservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class AppUser {

    private String id;
    private String username;
    private String password;
    private String email;
    private Collection<Role> roles = new ArrayList<>();


}
