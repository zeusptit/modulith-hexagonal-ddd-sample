package com.modulithhexagonaldddsample.auth.domain.model;

import com.modulithhexagonaldddsample.auth.adapter.out.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private RoleEnum name;
    private List<Privilege> privileges;
}
