package com.modulithhexagonaldddsample.auth.application.port.out;

import com.modulithhexagonaldddsample.auth.domain.model.RefreshToken;
import com.modulithhexagonaldddsample.auth.domain.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RefreshTokenRepository {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    void deleteByUser(User user);

    RefreshToken save(RefreshToken refreshToken);

    void delete(RefreshToken token);
}
