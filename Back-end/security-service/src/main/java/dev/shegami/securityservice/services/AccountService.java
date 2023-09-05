package dev.shegami.securityservice.services;



import dev.shegami.securityservice.entities.AppUser;
import dev.shegami.securityservice.entities.Role;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);

    AppUser getUserById(String id);

    AppUser getUserByUsername(String username);

    Role addNewRole(Role role);

    void addRoleToUser(String username, String roleName);

    void deleteRoleFromUser(String username, String roleName);

    AppUser loadUserByUsername(String username);

    List<AppUser> listUser();

    void deleteRole(String id);

    void deleteUser(String id);
}
