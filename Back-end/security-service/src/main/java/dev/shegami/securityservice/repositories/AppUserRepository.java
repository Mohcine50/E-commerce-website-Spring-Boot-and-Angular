package dev.shegami.securityservice.repositories;


import dev.shegami.securityservice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

    AppUser findByUsername(String username);

}
