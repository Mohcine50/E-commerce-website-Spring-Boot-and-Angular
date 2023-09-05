package dev.shegami.profileservice.services;

import dev.shegami.profileservice.entities.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile>  listAllProfiles();
}
