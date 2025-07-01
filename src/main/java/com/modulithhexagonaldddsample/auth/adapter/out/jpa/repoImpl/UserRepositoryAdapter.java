package com.modulithhexagonaldddsample.auth.adapter.out.jpa.repoImpl;

import com.modulithhexagonaldddsample.auth.adapter.out.jpa.UserJpaRepository;
import com.modulithhexagonaldddsample.auth.application.mapper.UserMapper;
import com.modulithhexagonaldddsample.auth.application.port.out.UserRepository;
import com.modulithhexagonaldddsample.auth.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaRepository.findByUsername(username)
                .map(UserMapper::toDomain);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return jpaRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public User save(User user) {
        return UserMapper.toDomain(
                jpaRepository.save(UserMapper.toEntity(user))
        );
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(UserMapper::toDomain)
                .toList();
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return jpaRepository.saveAll(
                users.stream()
                        .map(UserMapper::toEntity)
                        .toList()
        ).stream()
                .map(UserMapper::toDomain)
                .toList();
    }
}
