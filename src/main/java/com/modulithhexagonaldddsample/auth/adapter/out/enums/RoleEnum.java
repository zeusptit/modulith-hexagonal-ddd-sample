package com.modulithhexagonaldddsample.auth.adapter.out.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    SYSTEM_ADMIN("System Admin"),
    USER("User"),
    GUEST("Guest"),
    MODERATOR("Moderator"),
    ADMIN("Admin"),
    ANONYMOUS("Anonymous"),
    BACK_OFFICE("Back Office"),
    DEVELOPER("Developer"),
    SUPPORT("Support"),
    TESTER("Tester"),
    CONTENT_CREATOR("Content Creator"),
    ANALYST("Analyst"),
    MANAGER("Manager"),
    EXECUTIVE("Executive"),
    PARTNER("Partner"),
    CUSTOMER("Customer"),
    VENDOR("Vendor"),
    AUDITOR("Auditor"),
    COMPLIANCE_OFFICER("Compliance Officer"),
    SECURITY_OFFICER("Security Officer"),
    MARKETING("Marketing"),
    SALES("Sales");

    private final String displayName;

    RoleEnum(String displayName) {
        this.displayName = displayName;
    }
}
