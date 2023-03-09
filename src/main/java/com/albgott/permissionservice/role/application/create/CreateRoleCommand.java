package com.albgott.permissionservice.role.application.create;

import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public record CreateRoleCommand(@NonNull UUID id, @NonNull String name, String description , UUID businessId,
                                List<String> permissionsNames) {
}
