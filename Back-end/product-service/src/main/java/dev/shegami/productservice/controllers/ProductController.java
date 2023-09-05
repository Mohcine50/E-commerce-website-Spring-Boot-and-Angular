package dev.shegami.productservice.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/inventory/product")
public class ProductController {
    @GetMapping()
    public ResponseEntity<Object> getAllCarts(){
        return new ResponseEntity<>(Map.of("Message", "product Received"), HttpStatusCode.valueOf(200));
    }
}
