package com.modulithhexagonaldddsample.auth.adapter.out.jpa.repoImpl;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.PrivilegeEntity;
import com.modulithhexagonaldddsample.auth.adapter.out.jpa.PrivilegeJpaRepository;
import com.modulithhexagonaldddsample.auth.application.mapper.PrivilegeMapper;
import com.modulithhexagonaldddsample.auth.application.port.out.PrivilegeRepository;
import com.modulithhexagonaldddsample.auth.domain.model.Privilege;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PrivilegeRepositoryAdapter implements PrivilegeRepository {

    private final PrivilegeJpaRepository privilegeJpaRepository;

    @Override
    public boolean isAllPrivilegesExits(List<Privilege> privileges) {
        List<String> names = privileges.stream()
                .map(Privilege::getName)
                .toList();

        List<String> foundNames = privilegeJpaRepository.findByNameIn(names)
                .stream()
                .map(PrivilegeEntity::getName)
                .toList();

        return new HashSet<>(foundNames).containsAll(names);
    }


    @Override
    public Privilege save(Privilege privilege) {
        return PrivilegeMapper.toDomain(
                privilegeJpaRepository.save(PrivilegeMapper.toEntity(privilege))
        );
    }
}
