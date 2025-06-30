package com.modulithhexagonaldddsample.auth.application.port.in;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.SignUpRequest;
import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.UserRequest;
import com.modulithhexagonaldddsample.auth.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserUseCase {

    User createUser(SignUpRequest signUpRequest);
    User createUser(UserRequest userRequest);

    List<User> getAllUsers();
}
