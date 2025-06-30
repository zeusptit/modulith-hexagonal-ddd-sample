package com.modulithhexagonaldddsample.auth.adapter.out.jpa.repoImpl;

import com.modulithhexagonaldddsample.auth.adapter.out.enums.RoleEnum;
import com.modulithhexagonaldddsample.auth.adapter.out.jpa.RoleJpaRepository;
import com.modulithhexagonaldddsample.auth.application.mapper.RoleMapper;
import com.modulithhexagonaldddsample.auth.application.port.out.RoleRepository;
import com.modulithhexagonaldddsample.auth.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleJpaRepository roleJpaRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return roleJpaRepository.findByName(RoleEnum.valueOf(name))
                .map(RoleMapper::toDomain);
    }

    @Override
    public boolean existsByName(String roleName) {
        return roleJpaRepository.existsByName(RoleEnum.valueOf(roleName));
    }

    @Override
    public Role save(Role newRole) {
        return RoleMapper.toDomain(roleJpaRepository.save(RoleMapper.toEntity(newRole)));
    }
}
