package com.modulithhexagonaldddsample.auth.adapter.in.web;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.RoleRequest;
import com.modulithhexagonaldddsample.auth.application.port.in.RoleUseCase;
import com.modulithhexagonaldddsample.auth.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleUseCase roleUseCase;

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody RoleRequest roleRequest) {
        Role createdRole = roleUseCase.createRole(roleRequest);
        return ResponseEntity.ok(createdRole);
    }
}
