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
    ADMIN_ENABLE("admin:enable"),
    AGENT_READ("agent:read"),
    AGENT_CREATE("agent:update"),
    AGENT_DELETE("agent:delete"),
    AGENT_UPDATE("agent:update"),
    client_READ("client:read");


    @Getter
    private final String permission;
}
