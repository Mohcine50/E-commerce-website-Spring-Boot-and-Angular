package dev.shegami.cartservice.repositories;

import dev.shegami.cartservice.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, String> {
}
