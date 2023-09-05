package dev.shegami.orderservice.services;

import dev.shegami.orderservice.models.AppUser;


public interface AccountClientService {

    AppUser loadUserByUsername(String username);
}
