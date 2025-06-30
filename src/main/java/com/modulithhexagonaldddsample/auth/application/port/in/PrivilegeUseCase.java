package com.modulithhexagonaldddsample.auth.application.port.in;

import com.modulithhexagonaldddsample.auth.adapter.in.dto.request.PrivilegeRequest;
import com.modulithhexagonaldddsample.auth.domain.model.Privilege;
import org.springframework.stereotype.Service;

@Service
public interface PrivilegeUseCase {

    Privilege createPrivilege(PrivilegeRequest privilegeRequest);
}
