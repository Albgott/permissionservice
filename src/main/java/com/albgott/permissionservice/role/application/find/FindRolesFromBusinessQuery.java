package com.albgott.permissionservice.role.application.find;

import lombok.NonNull;

import java.util.UUID;

public record FindRolesFromBusinessQuery(@NonNull UUID businessId) {
}
