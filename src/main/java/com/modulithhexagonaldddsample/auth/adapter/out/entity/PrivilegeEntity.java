package com.modulithhexagonaldddsample.auth.adapter.out.entity;

import com.modulithhexagonaldddsample.shared.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "privileges")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivilegeEntity extends BaseEntity {
    private String name;
}
