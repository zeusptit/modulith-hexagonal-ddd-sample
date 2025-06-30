package com.modulithhexagonaldddsample.shared.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse <T> {
    private T data;
    private String message;
    private boolean success;
}
