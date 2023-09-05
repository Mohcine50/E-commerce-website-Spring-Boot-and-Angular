package dev.shegami.cartservice.repositories;

import dev.shegami.cartservice.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, String> {
}
