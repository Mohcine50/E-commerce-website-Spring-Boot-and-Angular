package dev.shegami.cartservice.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/cartItem")
public class CartItemController {

    @GetMapping()
    public ResponseEntity<Object> getAllCarts(){
        return new ResponseEntity<>(Map.of("Message", "CartsItems Received"), HttpStatusCode.valueOf(200));
    }

}
