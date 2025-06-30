package com.modulithhexagonaldddsample.auth.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    private Long id;
    private User user;
    private String token;
    private Instant expiryDate;
}
