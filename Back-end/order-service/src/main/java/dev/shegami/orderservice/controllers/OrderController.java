package dev.shegami.orderservice.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @GetMapping()
    public ResponseEntity<Object> getAllCarts(){
        return new ResponseEntity<>(Map.of("Message", "Orders Received"), HttpStatusCode.valueOf(200));
    }
}
