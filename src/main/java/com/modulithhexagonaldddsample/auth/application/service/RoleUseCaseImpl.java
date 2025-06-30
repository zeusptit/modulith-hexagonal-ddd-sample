package com.modulithhexagonaldddsample.auth.application.service;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.RoleRequest;
import com.modulithhexagonaldddsample.auth.adapter.out.enums.RoleEnum;
import com.modulithhexagonaldddsample.auth.application.port.in.RoleUseCase;
import com.modulithhexagonaldddsample.auth.application.port.out.PrivilegeRepository;
import com.modulithhexagonaldddsample.auth.application.port.out.RoleRepository;
import com.modulithhexagonaldddsample.auth.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleUseCaseImpl implements RoleUseCase {

    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;

    @Override
    public Role createRole(RoleRequest roleRequest) {
        Role role = new Role();
        role.setName(RoleEnum.valueOf(roleRequest.getName()));

        boolean isAllPrivileges = privilegeRepository.isAllPrivilegesExits(roleRequest.getPrivileges());
        if (!isAllPrivileges) {
            throw new IllegalArgumentException("Some privileges do not exist");
        }
        role.setPrivileges(roleRequest.getPrivileges());
        return roleRepository.save(role);
    }
}
