package com.modulithhexagonaldddsample.auth.adapter.out.jpa;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.RefreshTokenEntity;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenJpaRepository extends JpaRepository<RefreshTokenEntity, Long> {
    Optional<RefreshTokenEntity> findByToken(String token);

    @Modifying
    void deleteByUser(UserEntity user);
}
