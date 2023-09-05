package dev.shegami.profileservice.services;


import dev.shegami.profileservice.models.AppUser;


public interface AccountClientService {

    AppUser loadUserByUsername(String username);
}
