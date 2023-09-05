package dev.shegami.profileservice.services;


import dev.shegami.profileservice.feignClients.AccountServiceClient;
import dev.shegami.profileservice.models.AppUser;
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
