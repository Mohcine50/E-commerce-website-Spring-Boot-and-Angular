package dev.shegami.cartservice.services;

import dev.shegami.cartservice.models.AppUser;
import org.springframework.stereotype.Service;


public interface AccountClientService {

    AppUser loadUserByUsername(String username);
}
