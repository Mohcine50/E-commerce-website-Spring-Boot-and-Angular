package dev.shegami.cartservice.feignClients;


import dev.shegami.cartservice.models.AppUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SECURITY-SERVICE", contextId = "CART-SECURITY")
public interface AccountServiceClient {

    @GetMapping("api/user/{username}")
    AppUser findByUserName(@PathVariable("username") String username);
}
