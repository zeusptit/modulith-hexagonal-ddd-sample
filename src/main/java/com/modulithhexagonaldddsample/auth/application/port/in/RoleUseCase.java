package com.modulithhexagonaldddsample.auth.application.port.in;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.RoleRequest;
import com.modulithhexagonaldddsample.auth.domain.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleUseCase {

    /**
     * Creates a new role in the system.
     * @param role
     * @return
     */
    Role createRole(RoleRequest role);
}
