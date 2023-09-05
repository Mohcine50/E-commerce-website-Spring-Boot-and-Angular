package dev.shegami.orderservice.feignClients;


import dev.shegami.orderservice.models.AppUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SECURITY-SERVICE", contextId = "ORDER-SECURITY")
public interface AccountServiceClient {

    @GetMapping("api/user/{username}")
    AppUser findByUserName(@PathVariable("username") String username);
}
