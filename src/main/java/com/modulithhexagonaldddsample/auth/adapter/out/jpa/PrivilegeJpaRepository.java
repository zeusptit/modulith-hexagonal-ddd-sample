package com.modulithhexagonaldddsample.auth.adapter.out.jpa;

import com.modulithhexagonaldddsample.auth.adapter.out.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivilegeJpaRepository extends JpaRepository<PrivilegeEntity, Long> {
    List<PrivilegeEntity> findByNameIn(List<String> names);

}
