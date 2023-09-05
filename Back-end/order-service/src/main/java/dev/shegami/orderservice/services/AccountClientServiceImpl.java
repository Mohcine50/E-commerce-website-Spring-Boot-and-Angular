package dev.shegami.orderservice.services;


import dev.shegami.orderservice.feignClients.AccountServiceClient;
import dev.shegami.orderservice.models.AppUser;
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
