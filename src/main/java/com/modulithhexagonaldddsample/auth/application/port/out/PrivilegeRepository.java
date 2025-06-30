package com.modulithhexagonaldddsample.auth.application.port.out;

import com.modulithhexagonaldddsample.auth.domain.model.Privilege;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrivilegeRepository {

    boolean isAllPrivilegesExits(List<Privilege> privileges);

    Privilege save(Privilege privilege);
}
