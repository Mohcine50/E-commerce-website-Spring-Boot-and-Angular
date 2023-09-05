package dev.shegami.productservice.services;

import dev.shegami.productservice.models.AppUser;


public interface AccountClientService {

    AppUser loadUserByUsername(String username);
}
