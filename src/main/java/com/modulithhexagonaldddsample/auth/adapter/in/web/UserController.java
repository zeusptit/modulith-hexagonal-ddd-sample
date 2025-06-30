package com.modulithhexagonaldddsample.auth.adapter.in.web;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.UserRequest;
import com.modulithhexagonaldddsample.auth.application.port.in.UserUseCase;
import com.modulithhexagonaldddsample.auth.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userUseCase.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
//    @PreAuthorize("@authService.hasPrivilege('user:save')")
    @PreAuthorize("hasAuthority('user:create')")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User user = userUseCase.createUser(userRequest);
        return ResponseEntity.ok(user);
    }
}
