package dev.shegami.cartservice.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/cart")
@EnableMethodSecurity(prePostEnabled = true)
public class CartController {
    @GetMapping("test")
    @PreAuthorize("hasAuthority('SCOPE_MANAGER')")
    public ResponseEntity<Object> getAllCarts(){
        return new ResponseEntity<>(Map.of("Message", "Carts Received"), HttpStatusCode.valueOf(200));
    }
}
