package dev.shegami.profileservice.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/profile")
public class AddressController {
    @GetMapping()
    public ResponseEntity<Object> getAllCarts(){
        return new ResponseEntity<>(Map.of("Message", "Profile Received"), HttpStatusCode.valueOf(200));
    }
}
