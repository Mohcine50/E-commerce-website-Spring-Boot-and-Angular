package dev.shegami.cartservice.services;

import dev.shegami.cartservice.models.AppUser;
import dev.shegami.cartservice.feignClients.AccountServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AccountClientServiceImpl implements AccountClientService {

    private AccountServiceClient accountServiceClientRepo;
    @Override
    public AppUser loadUserByUsername(String username) {
         return accountServiceClientRepo.findByUserName(username);
    }
}
