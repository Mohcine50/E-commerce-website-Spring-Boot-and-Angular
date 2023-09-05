package dev.shegami.profileservice.repositories;

import dev.shegami.profileservice.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, String> {
}
