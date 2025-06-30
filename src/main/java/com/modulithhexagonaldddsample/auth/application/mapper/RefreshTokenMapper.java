package com.modulithhexagonaldddsample.auth.application.mapper;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.RefreshTokenEntity;
import com.modulithhexagonaldddsample.auth.domain.model.RefreshToken;

public class RefreshTokenMapper {
    public static RefreshTokenEntity toEntity(RefreshToken refreshToken) {
        if (refreshToken == null) {
            return null;
        }

        RefreshTokenEntity entity = new RefreshTokenEntity();
        entity.setId(refreshToken.getId());
        entity.setUser(UserMapper.toEntity(refreshToken.getUser()));
        entity.setToken(refreshToken.getToken());
        entity.setExpiryDate(refreshToken.getExpiryDate());
        return entity;
    }

    public static RefreshToken toDomain(RefreshTokenEntity entity) {
        if (entity == null) {
            return null;
        }

        return new RefreshToken(
                entity.getId(),
                UserMapper.toDomain(entity.getUser()),
                entity.getToken(),
                entity.getExpiryDate()
        );
    }
}
