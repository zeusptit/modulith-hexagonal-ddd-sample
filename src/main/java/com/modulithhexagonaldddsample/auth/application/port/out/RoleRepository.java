package com.modulithhexagonaldddsample.auth.application.port.out;


import com.modulithhexagonaldddsample.auth.domain.model.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(String name);

    boolean existsByName(String roleName);

    Role save(Role newRole);
}
