package com.modulithhexagonaldddsample.auth.application.mapper;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.PrivilegeEntity;
import com.modulithhexagonaldddsample.auth.domain.model.Privilege;

public class PrivilegeMapper {
    public static Privilege toDomain(PrivilegeEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Privilege(
                entity.getId(),
                entity.getName()
        );
    }

    public static PrivilegeEntity toEntity(Privilege privilege) {
        if (privilege == null) {
            return null;
        }
        PrivilegeEntity entity = new PrivilegeEntity();
        entity.setId(privilege.getId());
        entity.setName(privilege.getName());
        return entity;
    }
}
