package com.modulithhexagonaldddsample.auth.adapter.out.jpa.repoImpl;

import com.modulithhexagonaldddsample.auth.adapter.out.jpa.RefreshTokenJpaRepository;
import com.modulithhexagonaldddsample.auth.application.mapper.RefreshTokenMapper;
import com.modulithhexagonaldddsample.auth.application.mapper.UserMapper;
import com.modulithhexagonaldddsample.auth.application.port.out.RefreshTokenRepository;
import com.modulithhexagonaldddsample.auth.domain.model.RefreshToken;
import com.modulithhexagonaldddsample.auth.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RefreshTokenRepositoryAdapter implements RefreshTokenRepository {

    private final RefreshTokenJpaRepository refreshTokenJpaRepository;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenJpaRepository.findByToken(token)
                .map(RefreshTokenMapper::toDomain);
    }

    @Override
    public void deleteByUser(User user) {
        refreshTokenJpaRepository.deleteByUser(UserMapper.toEntity(user));
    }

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        return RefreshTokenMapper.toDomain(
                refreshTokenJpaRepository.save(RefreshTokenMapper.toEntity(refreshToken))
        );
    }

    @Override
    public void delete(RefreshToken token) {
        refreshTokenJpaRepository.delete(RefreshTokenMapper.toEntity(token));
    }
}
