package dev.shegami.productservice.services;


import dev.shegami.productservice.feignClients.AccountServiceClient;
import dev.shegami.productservice.models.AppUser;
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
