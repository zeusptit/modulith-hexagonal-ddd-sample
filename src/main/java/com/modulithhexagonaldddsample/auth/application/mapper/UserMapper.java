package com.modulithhexagonaldddsample.auth.application.mapper;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.RoleEntity;
import com.modulithhexagonaldddsample.auth.adapter.out.entity.UserEntity;
import com.modulithhexagonaldddsample.auth.adapter.out.enums.RoleEnum;
import com.modulithhexagonaldddsample.auth.domain.model.Role;
import com.modulithhexagonaldddsample.auth.domain.model.User;

import java.util.List;

public class UserMapper {

    public static User toDomain(UserEntity entity) {
        List<Role> roles = entity.getRoles().stream()
                .map(roleEntity -> new Role(
                        roleEntity.getId(),
                        RoleEnum.valueOf(roleEntity.getName().name()),
                        roleEntity.getPrivileges().stream()
                                .map(PrivilegeMapper::toDomain)
                                .toList()
                ))
                .toList();

        return new User(
                entity.getId(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword(),
                roles
        );
    }

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setRoles(user.getRoles().stream()
                .map(role -> {
                    RoleEntity roleEntity = new RoleEntity();
                    roleEntity.setId(role.getId());
                    roleEntity.setName(role.getName());
                    roleEntity.setPrivileges(role.getPrivileges().stream()
                            .map(PrivilegeMapper::toEntity)
                            .toList());
                    return roleEntity;
                })
                .toList());
        return entity;
    }
}
