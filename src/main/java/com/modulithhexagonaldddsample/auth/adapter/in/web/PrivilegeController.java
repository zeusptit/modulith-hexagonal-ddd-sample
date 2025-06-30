package com.modulithhexagonaldddsample.auth.adapter.in.web;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.PrivilegeRequest;
import com.modulithhexagonaldddsample.auth.application.port.in.PrivilegeUseCase;
import com.modulithhexagonaldddsample.auth.domain.model.Privilege;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/privileges")
@RequiredArgsConstructor
public class PrivilegeController {

    private final PrivilegeUseCase privilegeUseCase;

    @PostMapping
    public ResponseEntity<Privilege> createPrivilege(@RequestBody PrivilegeRequest privilegeRequest) {
        Privilege privilege = privilegeUseCase.createPrivilege(privilegeRequest);
        return ResponseEntity.ok(privilege);
    }
}
