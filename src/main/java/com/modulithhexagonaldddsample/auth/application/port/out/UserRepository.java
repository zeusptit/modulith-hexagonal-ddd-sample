package com.modulithhexagonaldddsample.auth.application.port.out;

import com.modulithhexagonaldddsample.auth.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRepository {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    Optional<User> findById(Long id);

    User save(User user);

    List<User> findAll();
}
