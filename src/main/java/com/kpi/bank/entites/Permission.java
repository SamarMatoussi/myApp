package com.kpi.bank.entites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_DISABLE("admin:disable"),
    ADMIN_ENABLE("admin:enable");

    @Getter
    private final String permission;
}
