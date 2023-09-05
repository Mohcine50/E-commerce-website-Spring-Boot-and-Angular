package dev.shegami.productservice.repositories;

import dev.shegami.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
