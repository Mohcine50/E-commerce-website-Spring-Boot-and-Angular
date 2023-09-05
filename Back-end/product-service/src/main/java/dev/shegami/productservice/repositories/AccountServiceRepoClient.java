package dev.shegami.productservice.repositories;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "SECURITY-SERVICE")
public interface AccountServiceRepoClient {
}
