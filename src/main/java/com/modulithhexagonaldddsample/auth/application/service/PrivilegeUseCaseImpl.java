package com.modulithhexagonaldddsample.auth.application.service;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.PrivilegeRequest;
import com.modulithhexagonaldddsample.auth.application.port.in.PrivilegeUseCase;
import com.modulithhexagonaldddsample.auth.application.port.out.PrivilegeRepository;
import com.modulithhexagonaldddsample.auth.domain.model.Privilege;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class PrivilegeUseCaseImpl implements PrivilegeUseCase {

    private final PrivilegeRepository privilegeRepository;

    @Override
    public Privilege createPrivilege(PrivilegeRequest privilegeRequest) {
        Privilege privilege = new Privilege(privilegeRequest.getName());

        if (privilegeRepository.isAllPrivilegesExits(Arrays.asList(privilege))) {
            throw new IllegalArgumentException("Privilege already exists");
        }

        return privilegeRepository.save(privilege);
    }
}
