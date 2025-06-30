package com.modulithhexagonaldddsample.auth.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String username;
    private String password;
    private List<Role> roles;

    public User(String username, String email, String encode) {
        this.username = username;
        this.email = email;
        this.password = encode;
    }

    public boolean hasPrivilege(String privilegeName) {
        return roles.stream()
                .flatMap(r -> r.getPrivileges().stream())
                .anyMatch(p -> p.getName().equals(privilegeName));
    }
}
