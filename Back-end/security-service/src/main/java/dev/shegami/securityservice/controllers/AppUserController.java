package dev.shegami.securityservice.controllers;

import dev.shegami.securityservice.entities.AppUser;
import dev.shegami.securityservice.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AppUserController {


    private AccountService accountService;

    @GetMapping("api/user/{username}")
    public AppUser findByUserName(@PathVariable("username") String username){
       return accountService.loadUserByUsername(username);
    }
}
