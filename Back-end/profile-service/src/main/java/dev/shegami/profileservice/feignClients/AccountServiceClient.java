package dev.shegami.profileservice.feignClients;


import dev.shegami.profileservice.models.AppUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SECURITY-SERVICE", contextId = "PROFILE-SECURITY")
public interface AccountServiceClient {

    @GetMapping("api/user/{username}")
    AppUser findByUserName(@PathVariable("username") String username);
}
