package com.modulithhexagonaldddsample.auth.adapter.in.dto.request;

import com.modulithhexagonaldddsample.auth.domain.model.Privilege;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    private String name;
    private List<Privilege> privileges;
}
