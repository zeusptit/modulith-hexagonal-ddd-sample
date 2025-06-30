package com.modulithhexagonaldddsample.auth.adapter.out.jpa;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.RoleEntity;
import com.modulithhexagonaldddsample.auth.adapter.out.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(RoleEnum attr0);

    boolean existsByName(RoleEnum name);
}
