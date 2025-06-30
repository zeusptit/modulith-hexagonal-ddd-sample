package com.modulithhexagonaldddsample.auth.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {
    private Long id;
    private String name;

    public Privilege(String name) {
        this.name = name;
    }
}
