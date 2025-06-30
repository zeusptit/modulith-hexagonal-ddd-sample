package com.modulithhexagonaldddsample.auth.application.mapper;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.PrivilegeEntity;
import com.modulithhexagonaldddsample.auth.adapter.out.entity.RoleEntity;
import com.modulithhexagonaldddsample.auth.domain.model.Role;

import java.util.List;

public class RoleMapper {

    public static Role toDomain(RoleEntity entity) {
        if (entity == null) return null;

        return new Role(
                entity.getId(),
                entity.getName(), // assuming it's RoleEnum
                entity.getPrivileges() != null
                        ? entity.getPrivileges().stream()
                        .map(PrivilegeMapper::toDomain)
                        .toList()
                        : List.of()
        );
    }

    public static RoleEntity toEntity(Role domain) {
        if (domain == null) return null;

        RoleEntity entity = new RoleEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());

        if (domain.getPrivileges() != null) {
            List<PrivilegeEntity> privilegeEntities = domain.getPrivileges().stream()
                    .map(PrivilegeMapper::toEntity)
                    .toList();
            entity.setPrivileges(privilegeEntities);
        }

        return entity;
    }
}

