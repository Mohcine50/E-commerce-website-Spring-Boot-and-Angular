package dev.shegami.profileservice.repositories;

import dev.shegami.profileservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, String> {
}
